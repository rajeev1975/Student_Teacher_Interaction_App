package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class UploadAttendance extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<String> list;
    AttendanceAdapter attendanceAdapter;
    LinearLayout cLinear;
    RadioGroup attendance;
    TextView showDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_attendance);

        recyclerView = findViewById(R.id.recyclerView);
        attendance = findViewById(R.id.attendance);
        showDate = findViewById(R.id.showDate);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<String>();

        reference = FirebaseDatabase.getInstance().getReference("Students detail");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String detail = dataSnapshot1.child("reg_no").getValue().toString();
                    list.add(detail);
                }
                attendanceAdapter = new AttendanceAdapter(UploadAttendance.this, list);
                recyclerView.setAdapter(attendanceAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(UploadAttendance.this, "UNSUCCESSFULL", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
