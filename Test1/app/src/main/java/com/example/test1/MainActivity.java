package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button next_btn;
    TextView mtextview;
    EditText medtitext;


    private   final String MY_FILE = "USER";
    private final int PRIVATE_MODE = 0;

    SharedPreferences sharedPreferences;
    private static final  String KEY_NAME = "name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mtextview = findViewById( R.id.m_tv);
        medtitext = findViewById(R.id.m_et);
        next_btn = findViewById(R.id.m_next_btn);

        sharedPreferences = getSharedPreferences(MY_FILE,PRIVATE_MODE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        if(name!= null){
            Intent intent = new Intent(MainActivity.this,NameActivity.class);
            startActivity(intent);
        }
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SharedPreferences.Editor editor = sharedPreferences.edit();
              editor.putString(KEY_NAME,medtitext.getText().toString());
              editor.apply();
              startActivity(new Intent(MainActivity.this,NameActivity.class));

            }
        });
    }



}