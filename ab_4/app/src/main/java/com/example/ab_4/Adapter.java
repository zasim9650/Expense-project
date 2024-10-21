package com.example.ab_4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<MyModal> list;
    LayoutInflater inflater;


    public Adapter(Context context, String addArray) {
        this.context = context;
        this.list = addArray;
    }

    // inflater= LayoutInflater.from(context);
    @Override
    public int getCount() {
        return list.size();


    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView= inflater.inflate(R.layout.todo_list,null);
        TextView textView = convertView.findViewById(R.id.item_tv);

        textView.setText( list.get(position));


        if(convertView!=null){


          convertView.setBackgroundColor(Color.RED);
            notifyDataSetChanged();
        }
        else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;


    }


}
