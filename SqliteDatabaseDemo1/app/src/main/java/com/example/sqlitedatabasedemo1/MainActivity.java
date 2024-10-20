package com.example.sqlitedatabasedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabasedemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
EditText reg_name,reg_email,reg_gender,reg_pass;
 DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        reg_name=(EditText) findViewById(R.id.et_name);
        reg_email=(EditText) findViewById(R.id.et_email);
        reg_gender=(EditText) findViewById(R.id.et_gender);
        reg_pass=(EditText) findViewById(R.id.et_password);

        dbHelper = new DbHelper(getApplicationContext());



    }


            public void registerUser(View view) {
                String name=reg_name.getText().toString();
                String email=reg_email.getText().toString();
                String pass=reg_pass.getText().toString();
                String gender=reg_gender.getText().toString();

                boolean b= dbHelper.registerUserHelper(name,email,pass,gender);


                if(b==true){

                    Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();

                    reg_name.setText("");
                    reg_email.setText("");
                    reg_gender.setText("");
                    reg_pass.setText("");


                }

                else{
                    Toast.makeText(MainActivity.this, "User Not Registered", Toast.LENGTH_SHORT).show();
                }



            }

    }

