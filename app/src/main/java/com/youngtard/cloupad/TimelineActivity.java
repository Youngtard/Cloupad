package com.youngtard.cloupad;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.youngtard.cloupad.adapter.ViewPagerAdapter;
import com.youngtard.cloupad.fragment.ClousFragment;
import com.youngtard.cloupad.fragment.RemindersFragment;

public class TimelineActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        getSupportActionBar().setTitle("Timeline");

//        toolbar = findViewById(R.id.tb_tool_bar);
//        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tl_tab_layout);
        viewPager = findViewById(R.id.vp_view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ClousFragment(), "Clous");
        viewPagerAdapter.addFragment(new RemindersFragment(), "Reminders");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
