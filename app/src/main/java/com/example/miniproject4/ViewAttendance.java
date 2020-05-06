package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewAttendance extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ShowAttendanceHelper> list;
    ShowAttendanceAdapter adapter;
    int present = 0, tClass = 0;
    float attenPercentage = 0.0f;
    TextView perAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        recyclerView = findViewById(R.id.recyclerViewAttendShow);
        perAttendance = findViewById(R.id.perAttendance);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<ShowAttendanceHelper>();

        String regNo2 = getIntent().getStringExtra("data");

        reference = FirebaseDatabase.getInstance().getReference("Attendance").child(regNo2);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    tClass++;
                    String date1 = dataSnapshot1.child("date").getValue().toString();
                    String attendance1 = dataSnapshot1.child("attendance").getValue().toString();

                    if (attendance1.equals("present")) {
                        present++;
                    }

                    ShowAttendanceHelper show1 = new ShowAttendanceHelper(attendance1, date1);
                    list.add(show1);

                    attenPercentage = (present * 100) / tClass;
                    String attenPercentage1 = "" + attenPercentage + "%";
                    perAttendance.setText(attenPercentage1);
                }
                adapter = new ShowAttendanceAdapter(ViewAttendance.this, list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(ViewAttendance.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
