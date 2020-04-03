package com.awadhesh22791.todoapp.activity.adapter;

import com.awadhesh22791.todoapp.fragment.CardPaymentFragment;
import com.awadhesh22791.todoapp.fragment.NetbankingPaymentFragment;
import com.awadhesh22791.todoapp.fragment.UpiPaymentFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PaymentPagerAdapter extends FragmentStatePagerAdapter {
    int numberOfTabs;
    public PaymentPagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numberOfTabs=numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new UpiPaymentFragment();
            case 1: return new CardPaymentFragment();
            case 2: return new NetbankingPaymentFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
