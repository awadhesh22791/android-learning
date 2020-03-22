package com.awadhesh22791.todoapp.dao;

import android.content.Context;

import com.awadhesh22791.todoapp.constant.Static;
import com.awadhesh22791.todoapp.entity.Todo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Todo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    public static final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, Static.DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase.Callback todoDatabaseCallback=new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(()->{
                TodoDao todoDao=INSTANCE.todoDao();
                INSTANCE.clearAllTables();
                Todo newTodo=new Todo();
                newTodo.todo="Demo Todo";
                todoDao.add(newTodo);
            });
        }
    };
}
