package com.example.chatapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.chatapplication.Adapter.FragmentAdapter;
import com.example.chatapplication.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;




public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
FirebaseAuth auth;
FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        // Star Action bar change color.....................................................................

       Objects.requireNonNull(getSupportActionBar())
               .setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary_color)));
            // Start Text color..............................................................
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html
                .fromHtml("<font color=\"#ffffff\">"+getString(R.string.app_name)+"</font>"));
        // End Text color..............................................................

       // End Action bar change color..............................................................


        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();

binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
binding.tablayout.setupWithViewPager(binding.viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.setting) {
            ;
            Toast.makeText(this, "Setting Clickable", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);

        }
        else if(itemId==R.id.groupChat){
            Intent intent=new Intent(MainActivity.this,GroupChatActivity.class);
            startActivity(intent);


        }
        else if (itemId == R.id.logout) {
            ;
            auth.signOut();
            Intent intent=new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
        }
        return true;
    }
}