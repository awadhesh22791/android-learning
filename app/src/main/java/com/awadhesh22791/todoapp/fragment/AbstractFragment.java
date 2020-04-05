package com.awadhesh22791.todoapp.fragment;

import com.awadhesh22791.todoapp.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class AbstractFragment extends Fragment {
    protected NavController findNavController(){
        NavHostFragment hostFragment= (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        return hostFragment.getNavController();
    }
}
