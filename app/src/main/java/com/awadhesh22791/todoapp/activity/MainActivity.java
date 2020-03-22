package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.activity.adapter.TodoListAdapter;
import com.awadhesh22791.todoapp.constant.Static;
import com.awadhesh22791.todoapp.entity.Todo;
import com.awadhesh22791.todoapp.viewmodel.TodoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    TodoViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model=new ViewModelProvider(this).get(TodoViewModel.class);

        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerView3);
        final TodoListAdapter adapter=new TodoListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        model.getAllTodos().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                adapter.setTodos(todos);
            }
        });
    }

    public void addNote(View view){
        EditText editText=findViewById(R.id.edit_text_todo);
        final String todo=editText.getText().toString();
        if(todo==null || todo.isEmpty()){
            Toast.makeText(this,"Todo not available",Toast.LENGTH_LONG).show();
            return;
        }
        Todo newTodo=new Todo();
        newTodo.todo=todo;
        model.insert(newTodo);
        editText.setText(Static.EMPTY_STRING);
    }
}
