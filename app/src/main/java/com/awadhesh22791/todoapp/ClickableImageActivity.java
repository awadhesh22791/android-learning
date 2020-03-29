package com.awadhesh22791.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ClickableImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_image);
    }
    public void displayToastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        displayToastMessage(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        displayToastMessage(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        displayToastMessage(getString(R.string.froyo_order_message));
    }
}
