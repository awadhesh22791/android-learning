package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.awadhesh22791.todoapp.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar=findViewById(R.id.nav_top_toolbar);
        toolbar.setTitle("Navigation Home");
        setSupportActionBar(toolbar);
    }
}
