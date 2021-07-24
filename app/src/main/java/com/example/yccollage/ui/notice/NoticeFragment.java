package com.example.yccollage.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yccollage.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {
    private RecyclerView userNoticerecycle;
    private ProgressBar pgbar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;

    private DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        userNoticerecycle = view.findViewById(R.id.userNoticerecycle);
        pgbar = view.findViewById(R.id.pgbar);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");

        userNoticerecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        userNoticerecycle.setHasFixedSize(true);


        getNotice();
        return view;
    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    NoticeData data = snapshot.getValue(NoticeData.class);
                    list.add(0,data);

                }
                adapter = new NoticeAdapter(getContext(), list);
                adapter.notifyDataSetChanged();
                pgbar.setVisibility(View.GONE);
                userNoticerecycle.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                pgbar.setVisibility(View.GONE);;
                Toast.makeText(getContext(),databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
