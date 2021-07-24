package com.example.yccollage.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yccollage.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {
    private SliderView sliderView;
    private int[] images;
    private ImageView map;

    private sliderAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = view.findViewById(R.id.sliderView);
        images = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
        adapter = new sliderAdapter(images);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.COLOR);
        sliderView.startAutoCycle();


        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();

            }
        });



        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Yashwantrao Chavan College of Science karad");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);

    }
}