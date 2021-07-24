package com.example.yccollage.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yccollage.R;
import com.example.yccollage.ui.notice.NoticeAdapter;
import com.example.yccollage.ui.notice.NoticeData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csdept,phydept,chemdept,biodept,maradept;
    private LinearLayout csnodata,chemnodata,phynodata,bionodata,maranodata;
    private List<TeacherData> list1,list2, list3, list4,list5;
    private DatabaseReference reference,dbref;
    private ProgressBar cspgbar,chpgbar,ppgbar,bpgbar,mpgbar;
    private TeacherAdapter adapter;
    private NestedScrollView cs,phy,chem,bio,marathi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        csnodata = view.findViewById(R.id.csnodata);
        cspgbar = view.findViewById(R.id.cspgbar);
        bpgbar = view.findViewById(R.id.bpgbar);
        ppgbar = view.findViewById(R.id.ppgbar);
        chpgbar = view.findViewById(R.id.chpgbar);
        mpgbar = view.findViewById(R.id.mpgbar);


        phynodata = view.findViewById(R.id.phynodata);
        chemnodata = view.findViewById(R.id.chemnodata);
        bionodata = view.findViewById(R.id.bionodata);
        maranodata = view.findViewById(R.id.maranodata);

        csdept = view.findViewById(R.id.csdept);
        phydept = view.findViewById(R.id.phydept);
        chemdept = view.findViewById(R.id.chemdept);
        biodept = view.findViewById(R.id.biodept);
        maradept = view.findViewById(R.id.maradept);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csdept();
        phydept();
        chemdept();
        maradept();
        biodept();

        return view;


    }


    private void chemdept() {
        dbref = reference.child("Chem");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    chemnodata.setVisibility(View.  VISIBLE);
                    chpgbar.setVisibility(View.GONE);

                }else {
                    chpgbar.setVisibility(View.GONE);
                    chemdept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);

                    }
                    chemdept.setHasFixedSize(true);
                    chemdept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    adapter.notifyDataSetChanged();
                    chpgbar.setVisibility(View.GONE);
                    chemdept.setAdapter(adapter);

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void biodept() {
        dbref = reference.child("bio");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bionodata.setVisibility(View.VISIBLE);
                    bpgbar.setVisibility(View.GONE);

                }else {
                    bpgbar.setVisibility(View.GONE);
                    biodept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);

                    }
                    biodept.setHasFixedSize(true);
                    biodept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    adapter.notifyDataSetChanged();
                    bpgbar.setVisibility(View.GONE);
                    biodept.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {
                Toast.makeText(getContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csdept() {
        dbref = reference.child("Cs");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csnodata.setVisibility(View.VISIBLE);
                    cspgbar.setVisibility(View.GONE);

                }else {
                    cspgbar.setVisibility(View.GONE);
                    csdept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);

                    }
                    csdept.setHasFixedSize(true);
                    csdept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    adapter.notifyDataSetChanged();
                    cspgbar.setVisibility(View.GONE);
                    csdept.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {
                Toast.makeText(getContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void phydept() {
        dbref = reference.child("Phy");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    phynodata.setVisibility(View.VISIBLE);
                    ppgbar.setVisibility(View.GONE);

                }else {
                    ppgbar.setVisibility(View.GONE);
                    phydept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);

                    }
                    phydept.setHasFixedSize(true);
                    phydept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    adapter.notifyDataSetChanged();
                    ppgbar.setVisibility(View.GONE);
                    phydept.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {
                Toast.makeText(getContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void maradept() {
        dbref = reference.child("marathi");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    maranodata.setVisibility(View.VISIBLE);
                    mpgbar.setVisibility(View.GONE);

                }else {
                    mpgbar.setVisibility(View.GONE);
                    maradept.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);

                    }
                    maradept.setHasFixedSize(true);
                    maradept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    adapter.notifyDataSetChanged();
                    mpgbar.setVisibility(View.GONE);
                    maradept.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError databaseError) {
                Toast.makeText(getContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}