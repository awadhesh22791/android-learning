package com.awadhesh22791.todoapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.awadhesh22791.todoapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends AbstractFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button buttonNext;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    // Navigate using actions
    //View.OnClickListener nextButtonListener=Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment,null);;
    View.OnClickListener nextButtonListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Navigate using fragment id
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action=
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            action.setTitle("Second Fragment");
           findNavController().navigate(action);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        buttonNext=view.findViewById(R.id.button_to_second_fragment);
        if(buttonNext!=null){
            buttonNext.setOnClickListener(nextButtonListener);
        }
        // Inflate the layout for this fragment
        return view;
    }
}
