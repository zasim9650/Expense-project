package com.example.whatsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.ChatDetailActivity;
import com.example.whatsapp.R;
import com.example.whatsapp.model.users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ArrayList<users> list;
    Context context;



    public UserAdapter(ArrayList<users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_show_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        users user=list.get(position);
       Picasso.get().load(user.getProfilepic()).placeholder(R.drawable.user).into(holder.image);
       holder.UserName.setText(user.getUserName());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context, ChatDetailActivity.class);
               intent.putExtra("userId",user.getUserId());
               intent.putExtra("profilePic",user.getProfilepic());
               intent.putExtra("userName",user.getUserName());

              context.startActivity(intent);

           }
       });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView UserName,LastMassage;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserName=itemView.findViewById(R.id.username);
           LastMassage=itemView.findViewById(R.id.lastmassage);
            image=itemView.findViewById(R.id.profile_image);
        }
    }
}
