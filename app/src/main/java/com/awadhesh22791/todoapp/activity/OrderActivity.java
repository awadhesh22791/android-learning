package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.constant.Field;

public class OrderActivity extends AppCompatActivity {
    private TextView orderMessage;
    private RadioButton radioButtonDeliveryMethod;
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
        radioButtonDeliveryMethod=findViewById(R.id.radio_button_delivery_method_same_day);
        radioButtonDeliveryMethod.setChecked(true);
    }

    public void selectDeliveryMethod(View view) {
        boolean checked=((RadioButton)view).isChecked();
        if(checked) {
            switch (view.getId()) {
                case R.id.radio_button_delivery_method_same_day:
                    displayMessage(getString(R.string.delivery_method_same_day));
                    break;
                case R.id.radio_button_delivery_method_next_day:
                    displayMessage(getString(R.string.delivery_method_next_day));
                    break;
                case R.id.radio_button_delivery_method_pickup:
                    displayMessage(getString(R.string.delivery_method_pick_up));
            }
        }
    }
    public void displayMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
