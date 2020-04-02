package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.activity.adapter.PaymentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class PaymentActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TabLayout tabLayout=findViewById(R.id.tabLayoutPayment);
        tabLayout.addTab(tabLayout.newTab().setText("UPI"));
        tabLayout.addTab(tabLayout.newTab().setText("CARD"));
        tabLayout.addTab(tabLayout.newTab().setText("NETBANKING"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager=findViewById(R.id.viewPagerPayment);
        PagerAdapter pagerAdapter=new PaymentPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
    }
    TabLayout.OnTabSelectedListener tabSelectedListener=new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
