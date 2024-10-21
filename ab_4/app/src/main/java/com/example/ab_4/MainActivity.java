package com.example.ab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
ArrayList addArray = new ArrayList<String>();
    Switch aSwitch;


    Button add_btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.edit_text);
        listView = findViewById(R.id.list_view);
        add_btn = findViewById(R.id.add_btn);
        aSwitch = findViewById(R.id.my_switch);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String getInput = editText.getText().toString();
                if(aSwitch.isChecked()){

                    if(addArray.contains(getInput)){

                        Toast.makeText(MainActivity.this, "Item already Add ", Toast.LENGTH_SHORT).show();
                    }
                    else if(getInput == null || getInput.trim().equals("")){
                        Toast.makeText(MainActivity.this, "input Field Empty", Toast.LENGTH_SHORT).show();

                    }

                    else {
                        addArray.addAll(Collections.singleton(getInput));
                        Adapter adapter = new Adapter(getApplicationContext(),getInput);
                        listView.setAdapter(adapter);
                        Toast.makeText(MainActivity.this, "Successfully Value Updated", Toast.LENGTH_SHORT).show();
                        ((EditText)findViewById(R.id.edit_text)).setText(" ");
                    }

                }

                else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }



            }


        });


    }
}