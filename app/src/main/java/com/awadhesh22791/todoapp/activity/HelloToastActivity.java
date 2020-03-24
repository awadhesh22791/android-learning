package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;

public class HelloToastActivity extends AppCompatActivity {

    private int mCount=0;
    TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_toast);
        mShowCount=(TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount!=null)
            mShowCount.setText(Integer.toString(mCount));
    }
}
