package com.awadhesh22791.todoapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.awadhesh22791.todoapp.activity.OrderActivity;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar currentCalender=Calendar.getInstance();
        int year=currentCalender.get(Calendar.YEAR);
        int month=currentCalender.get(Calendar.MONTH);
        int day=currentCalender.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        OrderActivity orderActivity= (OrderActivity) getActivity();
        orderActivity.initializeDeliveryDate(year,month,dayOfMonth);
    }
}
