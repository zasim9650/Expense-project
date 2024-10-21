package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;

 TextView textView;
 EditText editText;
 Switch aSwitch;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
       checkBox = findViewById(R.id.cb);

       
        aSwitch = findViewById(R.id.switch_btn);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               if(aSwitch.isChecked()){
                   String et =  editText.getText().toString();
                   textView.setText(et);
                   Toast.makeText(MainActivity.this, "successfully value Updated", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

              }

               checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                       if(isChecked){
                           Snackbar.make(v,"please check internet",Snackbar.LENGTH_SHORT)
                                   .setAction("undo", new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Snackbar.make(v,"please click the checkbox",Snackbar.LENGTH_SHORT).show();
                                       }
                                   }).show();
                       }
                       else {
                           Snackbar.make(v,"Error",Snackbar.LENGTH_SHORT).show();
                       }

                   }
               });


            }
        });
    }
}