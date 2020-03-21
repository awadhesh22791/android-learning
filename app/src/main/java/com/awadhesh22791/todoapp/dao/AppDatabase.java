package com.awadhesh22791.todoapp.dao;

import com.awadhesh22791.todoapp.entity.Todo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Todo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao noteDao();
}
