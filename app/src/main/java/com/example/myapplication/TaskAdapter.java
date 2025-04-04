//package com.example.myapplication;
//
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.ImageButton;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
//
//    private List<Task> TaskList;
//    private OnTaskInteraction Interaction;
//
//    public interface OnTaskInteraction {
//        void onTaskChecked(Task task, boolean isChecked);
//        void onTaskDelete(Task task);
//    }
//
//    public TaskAdapter(List<Task> TaskList, OnTaskInteraction Interaction){
//        this.TaskList=TaskList;
//        this.Interaction=Interaction;
//    }
//
//
//    @NonNull
//    @Override
//    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
//        return new TaskViewHolder(view);    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
