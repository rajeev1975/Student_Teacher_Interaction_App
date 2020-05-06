package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTeachersDetail extends AppCompatActivity {

    EditText name, deptNo, dept, email;
    Button save;

    RadioGroup rGen;
    RadioButton gen;
    String gen1;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teachers_detail);

        name = findViewById(R.id.name);
        dept = findViewById(R.id.dept);
        deptNo = findViewById(R.id.deptNo);
        email = findViewById(R.id.email);
        rGen = findViewById(R.id.gender);

        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Teachers' Detail");

                String name1 = name.getText().toString();
                String deptNo1 = deptNo.getText().toString();
                String dept1 = dept.getText().toString();
                String email1 = email.getText().toString();
                String password3 = getIntent().getStringExtra("password2");

                TeacherHelper helper = new TeacherHelper(name1, deptNo1, email1, dept1, gen1);
                reference.child(deptNo1).setValue(helper);
                Toast.makeText(AddTeachersDetail.this, "saved", Toast.LENGTH_SHORT).show();


                String detail = "Name : " + name1 + "\n" + "Dept No : " + deptNo1 + "\n" + "Dept No : " + deptNo1 + "\n" + "User id : " +
                        email1 + "\n" + "Password : " + password3;
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "You can login through given details below");
                intent.putExtra(Intent.EXTRA_TEXT, detail);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    public void checkButton(View view) {
        int genId = rGen.getCheckedRadioButtonId();
        gen = findViewById(genId);

        gen1 = gen.getText().toString();
        Toast.makeText(this, gen1, Toast.LENGTH_SHORT).show();
    }


}
