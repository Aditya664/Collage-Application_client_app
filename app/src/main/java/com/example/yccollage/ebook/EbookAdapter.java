package com.example.yccollage.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yccollage.R;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {
    private  Context context;
    private  List<EbookData> list;

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookAdapter.EbookViewHolder holder, int position) {
        holder.Ebookname.setText(list.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(context,PdfViewer.class);
                intent.putExtra("Durl",list.get(position).getDurl());
                context.startActivity(intent);


            }
        });
        holder.EbookDow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getDurl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {
        private TextView Ebookname;
        private ImageView EbookDow;
        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            EbookDow = itemView.findViewById(R.id.ebookdow);
            Ebookname = itemView.findViewById(R.id.ebooktitle);
        }
    }
}
