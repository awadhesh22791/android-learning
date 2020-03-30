package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.constant.Field;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        if(intent!=null && intent.hasExtra(Field.MESSAGE)) {
            TextView sentMessages=findViewById(R.id.text_view_sent_messages);
            sentMessages.setText(intent.getStringExtra(Field.MESSAGE));
        }
    }

    public void launchFirstActity(View view) {
        Intent secondActivityIntent=new Intent(this,FirstActivity.class);
        EditText editTextReplyMessage=findViewById(R.id.edit_reply);
        secondActivityIntent.putExtra(Field.MESSAGE,editTextReplyMessage.getText().toString());
        startActivity(secondActivityIntent);
    }
}
