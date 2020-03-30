package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.constant.Field;

public class ClickableImageActivity extends AppCompatActivity {
    private String mOrderMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_image);
    }
    public void displayToastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMessage="Donut";
        displayToastMessage(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage="Ice Cream";
        displayToastMessage(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        mOrderMessage="Froyo";
        displayToastMessage(getString(R.string.froyo_order_message));
    }

    public void orderDesert(View view) {
        Intent intent=new Intent(ClickableImageActivity.this, OrderActivity.class);
        intent.putExtra(Field.MESSAGE,mOrderMessage);
        startActivity(intent);
    }
}
