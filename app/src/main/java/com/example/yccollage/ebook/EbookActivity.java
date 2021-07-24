package com.example.yccollage.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yccollage.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView ebookrecy;
    private DatabaseReference reference;
    private List<EbookData> list;
    private ProgressBar pgbar;
    private EbookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        pgbar = findViewById(R.id.pgbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");



        ebookrecy = findViewById(R.id.Ebookrecy);
        reference = FirebaseDatabase.getInstance().getReference().child("Ebook");
        getdata();

    }

    private void getdata() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot snapshot : datasnapshot.getChildren()){
                    EbookData data = snapshot.getValue(EbookData.class);
                    list.add(data);


                }
                adapter = new EbookAdapter(EbookActivity.this, list);
                ebookrecy.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                adapter.notifyDataSetChanged();
                ebookrecy.setHasFixedSize(true);
                pgbar.setVisibility(View.GONE);
                ebookrecy.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}