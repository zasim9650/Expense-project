package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.whatsapp.Adapter.ChatAdapter;
import com.example.whatsapp.databinding.ActivityGroupChatBinding;
import com.example.whatsapp.model.MassageModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;
import java.util.Date;

public class GroupChatActivity extends AppCompatActivity {
ActivityGroupChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGroupChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GroupChatActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        final ArrayList<MassageModel> massageModels=new ArrayList<>();
        final String senderId= FirebaseAuth.getInstance().getUid();
        binding.userName.setText("Friends Group");
        final ChatAdapter adapter=new ChatAdapter(massageModels, this);
        binding.ChatRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.ChatRecyclerView.setLayoutManager(layoutManager);

//        firebaseDatabase.getReference().child("Group Chat")
//                        .addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                              massageModels.clear();
//                              for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//                                  MassageModel model=dataSnapshot.getValue(MassageModel.class);
//                                  massageModels.add(model);
//                              }
//                              adapter.notifyDataSetChanged();
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String massage=binding.writeMassage.getText().toString();
                final  MassageModel model=new MassageModel(senderId,massage);
                model.setTimestamp(new Date().getTime());
                binding.writeMassage.setText("");

                firebaseDatabase.getReference().child("Group Chat").push()
                        .setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });
            }
        });



    }
}