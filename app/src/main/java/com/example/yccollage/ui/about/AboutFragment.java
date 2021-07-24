package com.example.yccollage.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yccollage.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private PagerAdapter viewpager;
    private CourceAdapter adapter;
    private List<CourceModel> list;
    private  ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new CourceModel(R.drawable.ic_baseline_computer_24,"B. Sc. Honors Degree Courses","B. Sc. I: total subjects = FIVE (5) ( English + 4 Optional Subjects*) (Select any FOUR optional subjects as per combinations shown in our printed prospectus)"));
        list.add(new CourceModel(R.drawable.ic_baseline_electrical_services_24,"B.C.S ,Bachelor of Computer Science","A composite course of 3 years started in June 2008"));
        list.add(new CourceModel(R.drawable.ic_baseline_electrical_services_24,"M. Sc","microbio,Analytical Chemistry"));
        list.add(new CourceModel(R.drawable.ic_baseline_electrical_services_24,"M. Phil","1) Zoology 2) Botany"));
        list.add(new CourceModel(R.drawable.ic_baseline_electrical_services_24,"Ph D","Microbiology,Zoology"));

        adapter = new CourceAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


        return view;


    }
}