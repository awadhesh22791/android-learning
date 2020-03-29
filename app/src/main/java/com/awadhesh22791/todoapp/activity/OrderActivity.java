package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.constant.Field;

public class OrderActivity extends AppCompatActivity {
    private TextView orderMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent=getIntent();
        if(intent.hasExtra(Field.MESSAGE)){
            orderMessage=findViewById(R.id.text_view_order);
            String order=intent.getStringExtra(Field.MESSAGE);
            if(order!=null && !order.isEmpty())
                orderMessage.setText("You ordered: "+order);
            else
                orderMessage.setText("Please order something.");
        }else{
            orderMessage.setText("Please order something.");
        }
    }
}
