package com.awadhesh22791.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitActivity extends AppCompatActivity {
    private EditText editTextWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
    }

    public void openWebsite(View view) {
        editTextWebsite= findViewById(R.id.edit_text_website);
        Uri url= Uri.parse(editTextWebsite.getText().toString());
        Intent intentOpenWebsite=new Intent(Intent.ACTION_VIEW,url);
        if(intentOpenWebsite.resolveActivity(getPackageManager())!=null){
            startActivity(intentOpenWebsite);
        }else{
            Toast.makeText(this,"Not able to open website. Please check URL.",Toast.LENGTH_SHORT).show();
        }
    }

    public void openLocation(View view) {
    }

    public void shareText(View view) {
    }
}
