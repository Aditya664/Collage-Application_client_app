package com.example.yccollage.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.yccollage.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {
    private List<TeacherData> list;
    private Context context;

    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teacherfacultyitems, parent, false);

        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {

        final TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());

        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.avrtar1).into(holder.Imgview);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;

        private ImageView Imgview;


        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teachName);
            email = itemView.findViewById(R.id.teachemail);
            post = itemView.findViewById(R.id.teachPost);
            Imgview = itemView.findViewById(R.id.techimg);


        }
    }
}
