package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentsDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner semester;
    Button save;
    RadioGroup gender;
    RadioButton gen;

    EditText name, reg_no, branch, email;

    FirebaseDatabase database;
    DatabaseReference reference;

    String semester1;
    String gender1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_detail);

        semester = findViewById(R.id.semester);
        save = findViewById(R.id.save);
        gender = findViewById(R.id.gender);
        name = findViewById(R.id.name);
        reg_no = findViewById(R.id.regNo);
        branch = findViewById(R.id.branch);
        email = findViewById(R.id.email);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter);

        semester.setOnItemSelectedListener(this);


        //save button.........
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Students detail");

                //get all the values from edit text
                String name1 = name.getText().toString();
                String regNo1 = reg_no.getText().toString();
                String branch1 = branch.getText().toString();
                String email1 = email.getText().toString();
                String password3 = getIntent().getStringExtra("password2");

                StudentHelperClass helperClass = new StudentHelperClass(name1, regNo1, email1, branch1, semester1, gender1);
                reference.child(regNo1).setValue(helperClass);
                Toast.makeText(AddStudentsDetail.this, "Saved Successfully", Toast.LENGTH_SHORT).show();


                String detail = "Name : " + name1 + "\n" + "Reg No : " + regNo1 + "\n" + "Reg No : " + regNo1 + "\n" + "User id : " +
                        email1 + "\n" + "Password : " + password3;
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                String email = "rajeeb197515@gmail.com";

                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "You can login through given details below");
                intent.putExtra(Intent.EXTRA_TEXT, detail);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        semester1 = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, semester1, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void checkButton(View view) {
        int radioId = gender.getCheckedRadioButtonId();
        gen = findViewById(radioId);

        gender1 = gen.getText().toString();
        Toast.makeText(this, gender1, Toast.LENGTH_SHORT).show();
    }
}
