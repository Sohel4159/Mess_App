package com.example.mess_app;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<StudentData> arr;
    RecyclerAdapter(Context context,ArrayList<StudentData>arr)
    {
       this.context=context;
       this.arr=arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.student_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(arr.get(position).name);
        holder.reg_no.setText(arr.get(position).reg_no);
        holder.room.setText(arr.get(position).room_no);

    }

    @Override
    public int getItemCount()
    {
        return arr.size();
    }

    public class  ViewHolder extends  RecyclerView.ViewHolder{

        TextView name,reg_no,room;
        public  ViewHolder(View itemView)
        {

            super(itemView);
            this.name=itemView.findViewById(R.id.textName);
            this.reg_no=itemView.findViewById(R.id.textRegNo);
            this.room=itemView.findViewById(R.id.textRoomNo);
        }

    }


}

