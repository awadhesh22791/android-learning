package com.awadhesh22791.todoapp.viewmodel;

import android.app.Application;

import com.awadhesh22791.todoapp.entity.Todo;
import com.awadhesh22791.todoapp.repository.TodoRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TodoViewModel extends AbstractViewModel {
    private TodoRepository todoRepository;
    private LiveData<List<Todo>>todos;

    public TodoViewModel(Application application){
        super(application);
        todoRepository=new TodoRepository(application);
        todos=todoRepository.getAllTodos();
    }

    public LiveData<List<Todo>>getAllTodos(){ return todos;}

    public void insert(Todo todo){todoRepository.insert(todo);}

}
