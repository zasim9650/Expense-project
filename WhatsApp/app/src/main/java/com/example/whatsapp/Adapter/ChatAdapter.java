package com.example.whatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.ChatDetailActivity;
import com.example.whatsapp.GroupChatActivity;
import com.example.whatsapp.R;
import com.example.whatsapp.model.MassageModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {


    ArrayList<MassageModel> massageModels;
    Context context;

    public ChatAdapter(ArrayList<MassageModel> massageModels, Context context, String recId) {
        this.massageModels = massageModels;
        this.context = context;
        this.recId = recId;
    }

    String recId;

    int SENDER_VIEW_TYPE=1;
    int RECEIVER_VIEW_TYPE=2;


    public ChatAdapter(ArrayList<MassageModel> massageModels, GroupChatActivity context) {
        this.massageModels = massageModels;
        this.context = context;
    }

    public ChatAdapter(ArrayList<MassageModel> massageModels, ChatDetailActivity chatDetailActivity) {
    }

//    start onCreate method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (viewType == SENDER_VIEW_TYPE) {
           View view = LayoutInflater.from(context).inflate(R.layout.sample_sender, parent, false);
            return new SenderViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_reciever, parent, false);
            return new RecieverViewHolder(view);
        }
    }

    // End onCreate method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


// start getItemTypeView>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
    @Override
    public int getItemViewType(int position) {
        if(massageModels.get(position).getUid().equals(FirebaseAuth.getInstance().getUid())){
           return SENDER_VIEW_TYPE;
        }
        else{
            return RECEIVER_VIEW_TYPE;
        }
    }

//    End getItemTypeView>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.


    // start onBindViewHolder()method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MassageModel massageModel=massageModels.get(position);
        if(holder.getClass()==SenderViewHolder.class){
            ((SenderViewHolder) holder).senderMsg.setText(massageModel.getMassage());
        }
        else {
            ((RecieverViewHolder)holder).recieverMsg.setText(massageModel.getMassage());
        }
    }
    // End onBindViewHolder()method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




// start getItem Count method..............................................
    @Override
    public int getItemCount() {

        return massageModels.size();

    }
    // End getItem Count method..............................................................................................


    // start RecieverViewHolder() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public class RecieverViewHolder extends RecyclerView.ViewHolder {
        TextView recieverMsg,recieverTime;

        public RecieverViewHolder(@NonNull View itemView) {

            super(itemView);
            recieverMsg=itemView.findViewById(R.id.reciever_text);
            recieverTime=itemView.findViewById(R.id.reciever_time);
        }
    }
    // End RecieverViewHolder() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




   // start SenderViewHolder() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public class SenderViewHolder extends RecyclerView.ViewHolder{
        TextView senderMsg,senderTime;

        public SenderViewHolder(@NonNull View itemView) {

            super(itemView);


            senderMsg=itemView.findViewById(R.id.sender_time);
            senderTime=itemView.findViewById(R.id.sender_text);

        }
    }
    // End SenderViewHolder() method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


}
