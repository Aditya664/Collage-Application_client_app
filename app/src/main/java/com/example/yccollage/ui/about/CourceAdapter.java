package com.example.yccollage.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.yccollage.R;

import java.util.List;

public class CourceAdapter extends PagerAdapter {
    private Context context;
    private List<CourceModel> list;


    public CourceAdapter(Context context, List<CourceModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.cource_item_layout,container,false);
        ImageView courceicon;
        TextView crDecr,crTitle;

        courceicon = view.findViewById(R.id.courceicon);
        crDecr = view.findViewById(R.id.courcediscr);
        crTitle =  view.findViewById(R.id.courcetitle);


        courceicon.setImageResource(list.get(position).getImg());
        crTitle.setText(list.get(position).getTitle());
        crDecr.setText(list.get(position).getDicri());

        container.addView(view,0);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((View) object);
    }
}
