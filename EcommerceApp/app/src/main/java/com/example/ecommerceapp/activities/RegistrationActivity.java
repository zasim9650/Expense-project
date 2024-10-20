package com.example.ecommerceapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,pass;
    FirebaseAuth auth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        auth = FirebaseAuth.getInstance();
       name = findViewById(R.id.reg_user_name);
       email = findViewById(R.id.reg_user_email);
       pass = findViewById(R.id.reg_user_pass);

       sharedPreferences = getSharedPreferences("OnBoardingActivity",MODE_PRIVATE);
       Boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);

       if(isFirstTime){
           SharedPreferences.Editor editor = sharedPreferences.edit();
           editor.putBoolean("firstTime",false);
           editor.commit();
           Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
           startActivity(intent);
           finish();
       }

       if(auth.getCurrentUser()!=null){
           startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
           finish();

       }

    }

    public void signUp(View view){
        String reg_name = name.getText().toString();
        String reg_email = email.getText().toString();
        String reg_pass = pass.getText().toString();

        if(TextUtils.isEmpty(reg_name)){
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            return;

        }
        if(TextUtils.isEmpty(reg_email)){
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(reg_pass.length() < 6){
            Toast.makeText(this, "Password too short,please Enter minimum 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(reg_email,reg_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "Successfully Register ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this,MainActivity.class));

                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void signIn(View view){
      startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));

    }
}