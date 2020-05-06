package com.example.miniproject4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowAttendanceAdapter extends RecyclerView.Adapter<ShowAttendanceAdapter.MyViewHolder> {

    Context context;
    ArrayList<ShowAttendanceHelper> showAttendanceHelpers;

    public ShowAttendanceAdapter(Context context, ArrayList<ShowAttendanceHelper> showAttendanceHelpers) {
        this.context = context;
        this.showAttendanceHelpers = showAttendanceHelpers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.show_attendance_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        String check = showAttendanceHelpers.get(position).getDate();
        Toast.makeText(context, check, Toast.LENGTH_SHORT).show();
        holder.date.setText(check);

        holder.attend.setText(showAttendanceHelpers.get(position).getAttendance());

    }

    @Override
    public int getItemCount() {
        return showAttendanceHelpers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date, attend;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            attend = itemView.findViewById(R.id.attendance);
            date = itemView.findViewById(R.id.date);
        }
    }
}
