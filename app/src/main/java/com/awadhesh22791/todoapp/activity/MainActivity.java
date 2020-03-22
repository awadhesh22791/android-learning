package com.awadhesh22791.todoapp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.activity.adapter.TodoListAdapter;
import com.awadhesh22791.todoapp.constant.Static;
import com.awadhesh22791.todoapp.entity.Todo;
import com.awadhesh22791.todoapp.viewmodel.TodoViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    TodoViewModel model;
    private final int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model=new ViewModelProvider(this).get(TodoViewModel.class);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerView3);
        final TodoListAdapter adapter=new TodoListAdapter(this, new TodoListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Todo todo) {
                todo.completed=!todo.completed;
                model.update(todo);
            }
        });
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

    public void listenNote(View view){
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Please speak your todo.");
        try{
            startActivityForResult(intent,REQ_CODE);
        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(),"Sorry, your device not supported.",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQ_CODE:{
                if(resultCode==RESULT_OK && null!=data){
                    ArrayList result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    EditText editText=findViewById(R.id.edit_text_todo);
                    editText.setText(result.get(0).toString());
                }
            }
            break;
        }
    }
}
