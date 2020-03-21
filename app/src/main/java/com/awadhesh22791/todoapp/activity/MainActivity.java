package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.config.DBProvider;
import com.awadhesh22791.todoapp.dao.TodoDao;
import com.awadhesh22791.todoapp.entity.Todo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";

    private TodoDao todoDao=DBProvider.db.noteDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(DBProvider.db!=null){
            Toast.makeText(this,"DB connection open.",Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_main);
    }

    public void addNote(View view){
        EditText editText=findViewById(R.id.edit_text_todo);
        final String todo=editText.getText().toString();
        if(todo==null || todo.isEmpty()){
            Toast.makeText(this,"Todo not available",Toast.LENGTH_LONG).show();
            return;
        }
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Todo newTodo=new Todo();
                newTodo.todo=todo;
                todoDao.add(newTodo);
                List<Todo>todos=todoDao.getAll();
                Log.i(TAG, "Total Todos:"+todos.size());
            }
        });
    }
}
