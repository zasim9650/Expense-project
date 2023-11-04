package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        img=findViewById(R.id.imageView);
        Intent intent=getIntent();
        String action=intent.getAction();
        String type=intent.getType();
        if(intent.ACTION_SEND.equals(action) && type!=null){
           img.setImageURI(intent.getParcelableExtra(intent.EXTRA_STREAM));

        }
    }
}