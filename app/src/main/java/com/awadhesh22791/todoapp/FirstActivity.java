package com.awadhesh22791.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.awadhesh22791.todoapp.constant.Field;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent=getIntent();
        if(intent!=null && intent.hasExtra(Field.MESSAGE)) {
            TextView replyMessages=findViewById(R.id.text_view_replied_messages);
            replyMessages.setText(intent.getStringExtra(Field.MESSAGE));
        }
    }

    public void launchSecondActity(View view) {
        Intent secondActivityIntent=new Intent(this,SecondActivity.class);
        EditText message=findViewById(R.id.edit_send);
        secondActivityIntent.putExtra(Field.MESSAGE,message.getText().toString());
        startActivity(secondActivityIntent);
    }
}
