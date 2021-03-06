package com.awadhesh22791.todoapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.awadhesh22791.todoapp.fragment.TimePickerFragment;
import com.awadhesh22791.todoapp.fragment.DatePickerFragment;
import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.constant.Field;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String TAG="OrderActivity";
    private Button buttonOrderPayment;
    private TextView orderMessage;
    private EditText editTextPhone,deliveryDate,deliveryTime;
    private RadioButton radioButtonDeliveryMethod;
    private Spinner spinnerPhoneType;
    private List<String>additional=new ArrayList<>();

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
        if(radioButtonDeliveryMethod!=null)
            radioButtonDeliveryMethod.setChecked(true);
        spinnerPhoneType=findViewById(R.id.spinner_phone_type);
        if(spinnerPhoneType!=null){
            spinnerPhoneType.setOnItemSelectedListener(this);
            ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.phone_type,android.R.layout.simple_spinner_item);
            spinnerPhoneType.setAdapter(adapter);
        }
        editTextPhone=findViewById(R.id.edit_text_phone);
        if(editTextPhone!=null){
            editTextPhone.setOnEditorActionListener(editorActionListener);
        }
        deliveryDate=findViewById(R.id.edit_text_delivery_date);
        if(deliveryDate!=null){
            deliveryDate.setOnClickListener(deliveryDateClickListener);
        }
        deliveryTime=findViewById(R.id.edit_text_delivery_time);
        if(deliveryTime!=null){
            deliveryTime.setOnClickListener(deliveryTimeClickListener);
        }
        buttonOrderPayment=findViewById(R.id.order_payment);
        buttonOrderPayment.setOnClickListener(orderPaymentClickHandler);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void initializeDeliveryDate(int year, int month, int day){
        deliveryDate.setText(String.format("%02d",month)+"/"+String.format("%02d",day)+"/"+year);
    }

    public void initializeDeliveryTime(int hour,int minutes,String am_pm){
        deliveryTime.setText(String.format("%02d",hour)+":"+String.format("%02d",minutes)+" "+am_pm);
    }

    private View.OnClickListener orderPaymentClickHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), PaymentActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener deliveryTimeClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DialogFragment newFragment=new TimePickerFragment();
            newFragment.show(getSupportFragmentManager(),"timePicker");
        }
    };

    private View.OnClickListener deliveryDateClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            DialogFragment newFragment=new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(),"datePicker");
        }
    };

    private TextView.OnEditorActionListener editorActionListener=new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled=false;
            if(actionId== EditorInfo.IME_ACTION_SEND){
                dailNumber();
                handled=true;
            }
            return handled;
        }
    };

    private void dailNumber(){
        if(editTextPhone!=null){
            String phoneNumber="tel:"+editTextPhone.getText().toString();
            Log.i(TAG,"Dialing "+editTextPhone.getText().toString());
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(phoneNumber));
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivity(intent);
            }else{
                Log.d(TAG,"Can't handle dial phone number.");
            }
        }
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerLabel=adapterView.getItemAtPosition(position).toString();
        displayMessage(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addAdditional(View view) {
        CheckBox delight=((CheckBox)view);
        if(delight!=null) {
            boolean isAdditionalSelected = ((CheckBox) view).isChecked();
            if (isAdditionalSelected) {
                additional.add(delight.getText().toString());
            } else {
                additional.remove(delight.getText().toString());
            }
            Toast.makeText(getApplicationContext(),"Selected delight: "+additional.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
