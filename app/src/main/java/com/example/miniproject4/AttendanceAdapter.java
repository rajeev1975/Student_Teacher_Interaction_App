package com.example.miniproject4;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static java.util.Calendar.getInstance;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.MyViewHolder> implements DatePickerDialog.OnDateSetListener {
    Context context;
    ArrayList<String> attendancedHelpers;
    String date1 = "";

    FirebaseDatabase database;
    DatabaseReference reference;

    public AttendanceAdapter(Context context, ArrayList<String> attendancedHelpers) {
        this.context = context;
        this.attendancedHelpers = attendancedHelpers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.regNo.setText(attendancedHelpers.get(position));

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Attendance");


        holder.showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
                holder.date.setText(date1);

            }
        });


        holder.present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark = "present";
                Toast.makeText(context, "present is  clicked", Toast.LENGTH_SHORT).show();
                String regNo1 = attendancedHelpers.get(position);
                StoreAttendance storeAttendance = new StoreAttendance(date1, mark);
                reference.child(regNo1).child(date1).setValue(storeAttendance);
                Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });


        holder.absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark = "absent";
                String regNo1 = attendancedHelpers.get(position);
                StoreAttendance storeAttendance = new StoreAttendance(date1, mark);
                reference.child(regNo1).child(date1).setValue(storeAttendance);
                Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date1 = (month + 1) + " " + dayOfMonth + " " + year;
    }


    @Override
    public int getItemCount() {
        return attendancedHelpers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView regNo;
        RadioGroup attendance;
        RadioButton present, absent;
        TextView showDate;
        TextView date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            regNo = itemView.findViewById(R.id.regNo);
            attendance = itemView.findViewById(R.id.attendance);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);
            showDate = itemView.findViewById(R.id.showDate);
            date = itemView.findViewById(R.id.date);
        }
    }
}


