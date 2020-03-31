package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        Toolbar myToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_status:
                Toast.makeText(getApplicationContext(),"You selected Status.",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.action_favorites:
                Toast.makeText(getApplicationContext(),"You selected Favorites.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"You selected Settings.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_order:
                Toast.makeText(getApplicationContext(),"You selected Orders.",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
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
