package com.awadhesh22791.todoapp.dao;

import com.awadhesh22791.todoapp.entity.Todo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TodoDao {
    @Insert
    void add(Todo todo);

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);

    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAll();
}
