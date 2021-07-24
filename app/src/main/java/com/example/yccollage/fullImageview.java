package com.example.yccollage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class fullImageview extends AppCompatActivity {
private PhotoView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_imageview);

        imageView = findViewById(R.id.fillimg);


        String Image = getIntent().getStringExtra("imageurl_pass");
        String image = getIntent().getStringExtra("Image");

        Glide.with(this).load(image).into(imageView);
        Glide.with(this).load(Image).into(imageView);

    }
}