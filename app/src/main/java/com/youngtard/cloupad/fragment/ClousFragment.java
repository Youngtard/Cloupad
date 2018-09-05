package com.youngtard.cloupad.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youngtard.cloupad.EditClouActivity;
import com.youngtard.cloupad.R;
import com.youngtard.cloupad.adapter.ClousRecyclerAdapter;
import com.youngtard.cloupad.room.Clou;
import com.youngtard.cloupad.room.ClouDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClousFragment extends Fragment {
    View view;
    FloatingActionButton fab;
    private ClousRecyclerAdapter clousRecyclerAdapter;
    private RecyclerView clousRecyclerView;
    private ArrayList<Clou> clous;

    private ClouDatabase clouDatabase;

    public ClousFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_clous, container, false);

        clous = new ArrayList<Clou>();
        clousRecyclerView = view.findViewById(R.id.rv_clous);
        clousRecyclerAdapter = new ClousRecyclerAdapter(clous, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(clousRecyclerView.getContext(), layoutManager.getOrientation());
        clousRecyclerView.addItemDecoration((dividerItemDecoration));

        clousRecyclerView.setAdapter(clousRecyclerAdapter);
        clousRecyclerView.setLayoutManager(layoutManager);

        clouDatabase = ClouDatabase.getInstance(getActivity().getApplicationContext());



        //HOW CAN I PERSIST PRIMITIVE DATASTRUCTURES BETWEEN ACTIVITIES
        //USE DATABASE SERVICE - SQLITE, ROOM

//        Bundle extras = getActivity().getIntent().getExtras();
//        if(extras != null) {
//            String title = extras.getString("Title");
//            String content = extras.getString("Content");
//
//            Clou clou = new Clou(title, content);
//            clous.add(clou);
//        }

//            if(getArguments().getString("Content") == null) {
//                String title = getArguments().getString("Title");
//                String content = getArguments().getString("Content");
//
//                Clou clou = new Clou(title, content);
//                clous.add(clou);
//            }

        fab = view.findViewById(R.id.fab_add_clou);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditClouActivity.class);
                startActivity(intent);
            }
        });
        return view;




    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//    }

    @Override
    public void onResume() {
        super.onResume();
        clousRecyclerAdapter.setClous(clouDatabase.clouDao().loadAllClous());
    }


}
