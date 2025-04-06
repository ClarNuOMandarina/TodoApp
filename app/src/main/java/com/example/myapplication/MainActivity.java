package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText taskInput = findViewById(R.id.taskInput);
        EditText completionInput = findViewById(R.id.completionInput);
        Button AddTaskButton = findViewById(R.id.addTaskButton);
        Button RemoveTaskButton = findViewById(R.id.removeTaskButton);
        Button UpdateTaskButton = findViewById(R.id.updateTaskButton);
        ListView taskList = findViewById(R.id.taskList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, tasks);
        taskList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        taskList.setAdapter(adapter);

        AddTaskButton.setOnClickListener(v -> {
            String desc = taskInput.getText().toString();
            if (!desc.isEmpty()) {
                tasks.add(new Task(desc));
                adapter.notifyDataSetChanged();
                taskInput.setText("");
            }
        });

        RemoveTaskButton.setOnClickListener(v -> {
            int index = getSelectedIndex(taskList);
            if (index != -1) {
                tasks.remove(index);
                adapter.notifyDataSetChanged();
            }
        });

        UpdateTaskButton.setOnClickListener(v -> {
            int index = getSelectedIndex(taskList);
            if (index != -1) {
                String compStr = completionInput.getText().toString();
                try {
                    int completion = Integer.parseInt(compStr);
                    if (completion >= 0 && completion <= 100) {
                        tasks.get(index).completion = completion;
                        adapter.notifyDataSetChanged();
                        completionInput.setText("");
                    } else {
                        Toast.makeText(this, "Enter 0 to 100", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getSelectedIndex(ListView listView) {
        int pos = listView.getCheckedItemPosition();
        if (pos != ListView.INVALID_POSITION) {
            return pos;
        } else {
            Toast.makeText(this, "Select a task from the list", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }
}