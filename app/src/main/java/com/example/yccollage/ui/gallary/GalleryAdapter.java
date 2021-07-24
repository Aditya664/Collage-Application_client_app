package com.example.yccollage.ui.gallary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.yccollage.R;
import com.example.yccollage.fullImageview;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.galleryViewAdapter>
{


    private final Context context;
    private List<GalleryData> list;

    public GalleryAdapter(Context context, List<GalleryData> list)
    {

        this.context = context;
        this.list = list;
    }

    @Override
    public galleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.gallary_image,parent,false);
        return new galleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  galleryViewAdapter holder, int position)
   {
          try {

            Glide.with(context).load(list.get(position).getDurl()).into(holder.gallery_imageView);
            holder.gallery_imageView.setOnClickListener(v ->
            {
                Intent intent = new Intent(context, fullImageview.class);
                intent.putExtra("imageurl_pass",list.get(position).getDurl());
                context.startActivity(intent);
            });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "FAILED to load image", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class galleryViewAdapter extends RecyclerView.ViewHolder
    {
        ImageView gallery_imageView;

        public galleryViewAdapter(@NonNull  View itemView)
        {
            super(itemView);
            gallery_imageView = itemView.findViewById(R.id.img);



        }
    }






}
