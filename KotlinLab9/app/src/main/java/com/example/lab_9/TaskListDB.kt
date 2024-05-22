package com.example.lab_9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [TaskList::class], version = 1)
abstract class TaskListDB: RoomDatabase() {
    abstract fun tasksDao(): TaskListDao
}

@Entity(tableName = "tasks")
data class TaskList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "date") val date: String?
)

@Dao
interface TaskListDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<TaskList>

    @Insert
    fun insertAll(vararg taskLists: TaskList)

    @Delete
    fun delete (taskList: TaskList)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    fun deleteById(taskId: Int)
}
