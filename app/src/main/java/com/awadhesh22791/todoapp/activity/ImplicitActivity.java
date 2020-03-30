package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;

public class ImplicitActivity extends AppCompatActivity {
    private EditText editTextWebsite;
    private EditText editTextLocation;
    private EditText editTextMessage;

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
        editTextLocation =findViewById(R.id.edit_text_location);
        Uri addressUri=Uri.parse("geo:0,0?q="+ editTextLocation.getText().toString());
        Intent intentOpenLocation=new Intent(Intent.ACTION_VIEW,addressUri);
        if(intentOpenLocation.resolveActivity(getPackageManager())!=null){
            startActivity(intentOpenLocation);
        }else{
            Toast.makeText(this,"Not able to open location. Please check name of location.",Toast.LENGTH_SHORT).show();
        }
    }

    public void shareText(View view) {
        editTextMessage=findViewById(R.id.edit_text_message);
        String message=editTextMessage.getText().toString();
        ShareCompat.IntentBuilder
                .from(this).setType("text/plain").setChooserTitle("Share this text.")
                .setText(message).startChooser();
    }
}
