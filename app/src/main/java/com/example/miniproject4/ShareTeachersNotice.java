package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShareTeachersNotice extends AppCompatActivity {
    EditText notice, refNo;
    Button share;

    FirebaseDatabase database;
    DatabaseReference reference, reference1;

    String message1, refNo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_teachers_notice);

        notice = findViewById(R.id.notice);
        share = findViewById(R.id.share);
        refNo = findViewById(R.id.refNo);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Notice");


                refNo1 = refNo.getText().toString();
                String message = notice.getText().toString();

                ShareNoticeHelper helper = new ShareNoticeHelper(message);

                reference.child(refNo1).setValue(helper);

                Toast.makeText(ShareTeachersNotice.this, "saved Successfully", Toast.LENGTH_SHORT).show();


            }
        });


    }
}
