package com.awadhesh22791.todoapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public abstract class AbstractViewModel extends AndroidViewModel {
    protected AbstractViewModel(Application application){
        super(application);
    }
}
