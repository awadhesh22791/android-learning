package com.awadhesh22791.todoapp.config;

import android.app.Application;
import android.content.Context;

import com.awadhesh22791.todoapp.constant.Static;
import com.awadhesh22791.todoapp.dao.AppDatabase;

import androidx.room.Room;

public class DBProvider {
    public static AppDatabase db= null;
    private DBProvider(){}
    public static void initDB(){
        if(db==null){
            db=Room.databaseBuilder(TodoApp.getContext(),AppDatabase.class, Static.DATABASE_NAME).build();
        }
    }
}
