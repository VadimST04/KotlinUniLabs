package com.example.lab_9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.lab_9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        lateinit var database: TaskListDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            TaskListDB::class.java, "contact_database"
        ).build()
        val tasksDao = database.tasksDao()

        binding.addTaskButton.setOnClickListener {
            val name = binding.nameEdit.text.toString()
            val description = binding.descriptionEdit.text.toString()
            val date = binding.dateEdit.text.toString()
            val taskList = TaskList(name = name, description = description, date = date)
            GlobalScope.launch {
                tasksDao.insertAll(taskList)
            }

            Toast.makeText(
                applicationContext,
                "Task inserted",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.allTasksButton.setOnClickListener {
            GlobalScope.launch {
                val tasks = tasksDao.getAll()
                var tasksInfo = ""
                tasks.forEach {
                    tasksInfo += "${it.name} ${it.description} ${it.date}\n"
                }
                runOnUiThread {
                    binding.textView.text = tasksInfo
                }
            }
        }

        binding.deleteButton.setOnClickListener {
            val index = binding.idEdit.text.toString().toIntOrNull()

            if (index == null || index < 0) {
                Toast.makeText(
                    this,
                    "Invalid index. Please enter a valid number.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                val tasks = tasksDao.getAll()
                if (tasks.isNotEmpty() && index < tasks.size) {
                    val taskToDelete = tasks[index]
                    tasksDao.deleteById(taskToDelete.id)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "Task deleted successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivity,
                            "Invalid index. No task deleted.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}

