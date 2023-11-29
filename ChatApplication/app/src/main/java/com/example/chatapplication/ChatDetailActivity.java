package com.example.chatapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chatapplication.Adapter.ChatAdapter;
import com.example.chatapplication.Model.MassageModel;
import com.example.chatapplication.databinding.ActivityChatDetailBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

public class ChatDetailActivity extends AppCompatActivity {
    ActivityChatDetailBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         getSupportActionBar().hide();
        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();

        final  String senderId=auth.getUid();
        String receiverId=getIntent().getStringExtra("userId");
        String userName=getIntent().getStringExtra("userName");
        String profilePic=getIntent().getStringExtra("profilePic");


        binding.userName.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.user).into(binding.profileImage);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChatDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ArrayList<MassageModel>massageModels=new ArrayList<>();

        final ChatAdapter chatAdapter=new ChatAdapter(massageModels,this,receiverId);

        binding.chatRecyclerView.setAdapter(chatAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.chatRecyclerView.setLayoutManager(layoutManager);

        final String senderRoom=senderId+receiverId;
        final String receiverRoom=receiverId+senderId;



        //read data from database...............................................................

        database.getReference().child("CHATS")
                        .child(senderRoom).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        massageModels.clear();
                        for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                            MassageModel model=dataSnapshot.getValue(MassageModel.class);
                            model.setMassage(dataSnapshot.getKey());
                            massageModels.add(model);

                        }
                        chatAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        //End data from firebase database.....................................





        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String massage=  binding.editTextPersonalName.getText().toString();
              final MassageModel model=new MassageModel(senderId,massage);
              model.setTimestamp(new Date().getTime());
              binding.editTextPersonalName.setText("");

              database.getReference().child("CHATS").child(senderRoom).push().setValue(model)
                      .addOnSuccessListener(new OnSuccessListener<Void>() {
                          @Override
                          public void onSuccess(Void unused) {
                              database.getReference().child("CHATS").child(receiverRoom)
                                      .push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                                          @Override
                                          public void onSuccess(Void unused) {

                                          }
                                      });
                          }
                      });

            }
        });
    }
}