package com.awadhesh22791.todoapp.config;

import android.app.Application;
import android.content.Context;

public class TodoApp extends Application {
    private static Context context;
    public void onCreate(){
        super.onCreate();
        TodoApp.context=getApplicationContext();
        DBProvider.initDB();
    }

    public static Context getContext(){
        return TodoApp.context;
    }
}
