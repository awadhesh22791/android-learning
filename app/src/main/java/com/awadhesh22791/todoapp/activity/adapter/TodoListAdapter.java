package com.awadhesh22791.todoapp.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.awadhesh22791.todoapp.R;
import com.awadhesh22791.todoapp.entity.Todo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {
    public interface OnItemClickListener{
        void onItemClick(Todo todo);
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{
        private final CheckBox checkbox;
        private TodoViewHolder(View view){
            super(view);
            checkbox=view.findViewById(R.id.todoCheckBox);
        }
        public void bind(final Todo todo,final OnItemClickListener listener){
            checkbox.setId(todo.todoId);
            checkbox.setText(todo.todo);
            checkbox.setChecked(todo.completed);
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(todo);
                }
            });
        }
    }
    private final LayoutInflater inflater;
    private OnItemClickListener listener;
    private List<Todo> todos;
    public TodoListAdapter(Context context,OnItemClickListener listener){
        inflater=LayoutInflater.from(context);
        this.listener=listener;
    }
    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        if(todos!=null){
            Todo current=todos.get(position);
            holder.bind(current,listener);
        }else{

        }
    }

    public void setTodos(List<Todo>todos){
        this.todos=todos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(todos!=null){
            return todos.size();
        }
        return 0;
    }
}
