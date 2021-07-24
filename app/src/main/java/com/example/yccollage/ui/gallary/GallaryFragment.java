package com.example.yccollage.ui.gallary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.yccollage.R;

import java.util.ArrayList;


public class GallaryFragment extends Fragment {

    RecyclerView gallery_recyclerview1;
    RecyclerView gallery_recyclerview2;
    RecyclerView gallery_recyclerview3;
    RecyclerView gallery_recyclerview4;
    RecyclerView gallery_recyclerview5;
    private ProgressBar pgbar,pgbar1,pgbar2;




    GalleryAdapter adapter;
    private DatabaseReference Drefrance,DbRef;
    private ArrayList<GalleryData> listCT1,listCT2,listCT3,listCT4,listCT5;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallary, container, false);
        Drefrance = FirebaseDatabase.getInstance().getReference().child("Gallery");
        gallery_recyclerview1 = view.findViewById(R.id.gallery_recyclerview1);
        gallery_recyclerview2 = view.findViewById(R.id.gallery_recyclerview2);
        gallery_recyclerview3 = view.findViewById(R.id.gallery_recyclerview3);


        pgbar= view.findViewById(R.id.pgbar0);
        pgbar1 = view.findViewById(R.id.pgbar1);
        pgbar2 = view.findViewById(R.id.pgbar2);







        getCategory1();
        getCategory2();
        getCategory3();





        return view;
    }

    private void getCategory1()
    {
        Drefrance.child("placement").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot)
            {
                listCT1 = new ArrayList<>();

                for (DataSnapshot Dsnapshot : snapshot.getChildren())
                {
                    GalleryData data = Dsnapshot.getValue(GalleryData.class);
                    listCT1.add(data);
                }
                adapter = new GalleryAdapter(getContext(),listCT1);
                gallery_recyclerview1.setLayoutManager(new GridLayoutManager(getContext(),3));
                gallery_recyclerview1.setAdapter(adapter);
                pgbar.setVisibility(View.GONE);
                gallery_recyclerview1.setVisibility(View.VISIBLE);


            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error)
            {  Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getCategory2()
    {
        Drefrance.child("events").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot)
            {
                listCT2 = new ArrayList<>();

                for (DataSnapshot Dsnapshot : snapshot.getChildren())
                {
                    GalleryData data = Dsnapshot.getValue(GalleryData.class);
                    listCT2.add(data);
                }
                adapter = new GalleryAdapter(getContext(),listCT2);
                gallery_recyclerview2.setLayoutManager(new GridLayoutManager(getContext(),3));
                gallery_recyclerview2.setAdapter(adapter);
                pgbar1.setVisibility(View.GONE);
                gallery_recyclerview2.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error)
            {  Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getCategory3()
    {
        Drefrance.child("festivals").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot)
            {
                listCT3 = new ArrayList<>();


                for (DataSnapshot Dsnapshot : snapshot.getChildren())
                {
                    GalleryData data = Dsnapshot.getValue(GalleryData.class);
                    listCT3.add(data);
                }
                adapter = new GalleryAdapter(getContext(),listCT3);
                gallery_recyclerview3.setLayoutManager(new GridLayoutManager(getContext(),3));
                gallery_recyclerview3.setAdapter(adapter);
                pgbar2.setVisibility(View.GONE);
                gallery_recyclerview3.setVisibility(View.VISIBLE);


            }



            @Override
            public void onCancelled(@NonNull  DatabaseError error)
            {  Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}