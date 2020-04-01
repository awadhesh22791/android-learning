package com.awadhesh22791.todoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.awadhesh22791.todoapp.R;

public class TextScrollingViewActivity extends AppCompatActivity {
    private TextView articleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scrolling_view);
        articleView=findViewById(R.id.article);
        registerForContextMenu(articleView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.text_scroll_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit:
                Toast.makeText(getApplicationContext(),"You selected Edit",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share:
                Toast.makeText(getApplicationContext(),"You selected Share",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"You selected Delete",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
