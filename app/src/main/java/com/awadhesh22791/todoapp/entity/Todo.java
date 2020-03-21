package com.awadhesh22791.todoapp.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo extends AbstractEntity{
    @PrimaryKey(autoGenerate = true)
    public int todoId;

    @ColumnInfo(name="todo")
    public String todo;

    @ColumnInfo(name = "completed")
    public boolean completed;
}
