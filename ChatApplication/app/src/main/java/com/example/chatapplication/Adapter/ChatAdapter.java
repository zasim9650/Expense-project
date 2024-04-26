package com.example.chatapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapplication.ChatDetailActivity;
import com.example.chatapplication.Model.MassageModel;
import com.example.chatapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {
     ArrayList<MassageModel> massageModels;
     Context context;
     String recId;

    public ChatAdapter(ArrayList<MassageModel> massageModels, Context context, String recId) {
        this.massageModels = massageModels;
        this.context = context;
        this.recId = recId;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    int SENDER_VIEW_TYPE=1;
     int RECEIVER_VIEW_TYPE=2;

    public ChatAdapter(ArrayList<MassageModel> massageModels, Context context) {
        this.massageModels = massageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==SENDER_VIEW_TYPE){
            View view= LayoutInflater.from(context).inflate(R.layout.sample_sender ,parent ,false);
            return new SenderViewHolder(view);

        }
        else{
            View view= LayoutInflater.from(context).inflate(R.layout.sample_receiver ,parent ,false);
            return new ReceiverViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     MassageModel massageModel=massageModels.get(position);


     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             new AlertDialog.Builder(context)
                     .setTitle("Delete")
                     .setMessage("Are You sure You want to delete this massage")
                     .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                             FirebaseDatabase database=FirebaseDatabase.getInstance();
                             String senderRoom=FirebaseAuth.getInstance().getUid() + recId;
                             database.getReference().child("CHATS").child(senderRoom)
                                     .child(massageModel.getMassageId())
                                     .setValue(null);

                         }
                     }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     }).show();

         }
     });


     if(holder.getClass()== SenderViewHolder.class){
         ((SenderViewHolder)holder).senderMsg.setText(massageModel.getMassage());

     }
     else{
         ((ReceiverViewHolder)holder).receiverMsg.setText(massageModel.getMassage());
     }
    }

    @Override
    public int getItemCount() {
        return massageModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(massageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())){
            return SENDER_VIEW_TYPE;

        }
        else{
           return RECEIVER_VIEW_TYPE;
        }

    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder{
        TextView receiverMsg,receiverTime;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverMsg=itemView.findViewById(R.id.receiverText);
            receiverTime=itemView.findViewById(R.id.receiverTime);
        }
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder{

          TextView senderTime,senderMsg;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMsg=itemView.findViewById(R.id.senderText);
            senderTime=itemView.findViewById(R.id.senderTime);
        }
    }
}
