package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whatsapp.databinding.ActivitySignUp2Binding;
import com.example.whatsapp.model.users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signUpActivity extends AppCompatActivity {
private FirebaseAuth auth;
 FirebaseDatabase database;
  ProgressDialog progressDialog;

ActivitySignUp2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(signUpActivity.this);
        progressDialog.setTitle("creation User");
        progressDialog.setMessage("We are creating Account");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.etSignUpEmail.getText().toString(),
                        binding.etSignUpPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){


                            users user=new users(binding.etSignUpName.getText().toString(),
                                    binding.etSignUpPassword.getText().toString(),binding.etSignUpEmail.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("USERS").child(id).setValue(user);

//                           Toast.makeText(signUpActivity.this, "User Created Successfully", Toast.LENGTH_SHORT)
//                                   .setGravity(Gravity.CENTER|Gravity.RIGHT,0,0);
//                                   ;


                            Toast toast=new Toast(getApplicationContext());
                           View view= getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.ViewContainer));
                            toast.setView(view);
//
                            TextView textView=view.findViewById(R.id.txtmsg);
                            textView.setText("Massage successfully send");
                            toast.setDuration(Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER|Gravity.RIGHT,0,0);
                            toast.show();

//                            Intent intent=new Intent(signUpActivity.this, SignInActivity.class);
//                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(signUpActivity.this, "User Not Created", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        binding.tvAlreadySignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signUpActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }
}