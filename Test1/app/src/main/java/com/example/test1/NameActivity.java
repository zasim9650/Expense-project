package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView ntextview;
    private  final int REQUEST_CODE = 0;
    private  final int CODE = 1;
    Button ndont_call_btn,nthank_you_btn;
    private   final String MY_FILE = "USER";
    private final int PRIVATE_MODE = 0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final  String KEY_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        ndont_call_btn = findViewById(R.id.n_dont);
       nthank_you_btn = findViewById(R.id.n_btn_thank);
       ntextview = findViewById(R.id.n_tv);

       sharedPreferences = getSharedPreferences(MY_FILE,PRIVATE_MODE);
       String name = sharedPreferences.getString(KEY_NAME,null);
       if(name !=null){

           ntextview.setText("Name:" +name );

       }

       ndont_call_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (REQUEST_CODE ==0){
                   editor = sharedPreferences.edit();
                   editor.clear();
                   editor.commit();
                   finish();
                   if (REQUEST_CODE == 0){
                       startActivity(new Intent(NameActivity.this,MainActivity.class));
                   }
               }

           }
       });

        nthank_you_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                if (REQUEST_CODE == 1){
                    startActivity(new Intent(NameActivity.this,MainActivity.class));
                }


            }
        });

    }
}