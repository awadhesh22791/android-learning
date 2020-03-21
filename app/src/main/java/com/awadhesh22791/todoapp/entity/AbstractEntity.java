package com.awadhesh22791.todoapp.entity;

import androidx.room.ColumnInfo;

class AbstractEntity {
    @ColumnInfo(name = "deleted")
    public boolean deleted;
    @ColumnInfo(name="created_at",defaultValue = "CURRENT_TIMESTAMP")
    public String createdAt;
    @ColumnInfo(name="updated_at",defaultValue = "CURRENT_TIMESTAMP")
    public String updatedAt;
}
