package com.awadhesh22791.todoapp.repository;

import android.app.Application;

import com.awadhesh22791.todoapp.dao.AppDatabase;
import com.awadhesh22791.todoapp.dao.TodoDao;
import com.awadhesh22791.todoapp.entity.Todo;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TodoRepository {
    private TodoDao todoDao;
    private LiveData<List<Todo>>todos;

    public TodoRepository(Application application){
        AppDatabase db=AppDatabase.getDatabase(application);
        todoDao=db.todoDao();
        todos=todoDao.getAll();
    }

    public LiveData<List<Todo>> getAllTodos(){
        return todos;
    }

    public Todo getById(int id){return todoDao.getById(id);}

    public void update(Todo todo){
        AppDatabase.databaseWriteExecutor.execute(()->{
            todoDao.update(todo);
        });
    }

    public void insert(final Todo todo){
        AppDatabase.databaseWriteExecutor.execute(()->{
            todoDao.add(todo);
        });
    }
}
