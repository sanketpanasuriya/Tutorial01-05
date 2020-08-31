package com.example.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView fname,lname,uname,Password,Branch,Gender,City,Status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String firstname,lastname,username,password,branch,gender,city,status;
        firstname = intent.getStringExtra("First_name");
        lastname = intent.getStringExtra("Last_name");
        username = intent.getStringExtra("User_name");
        password = intent.getStringExtra("Password");
        branch = intent.getStringExtra("Branch");
        gender = intent.getStringExtra("Gender");
        city = intent.getStringExtra("City");
        status = intent.getStringExtra("Status");

        fname = findViewById(R.id.txtFirstname);
        lname = findViewById(R.id.txtLastname);
        uname = findViewById(R.id.txtUsername);
        Password = findViewById(R.id.txtPassword);
        Branch = findViewById(R.id.txtBranch);
        Gender = findViewById(R.id.txtGender);
        City = findViewById(R.id.txtCity);
        Status = findViewById(R.id.txtStatus);

        fname.setText(fname.getText().toString()+" "+firstname);
        lname.setText(lname.getText().toString()+" "+lastname);
        uname.setText(uname.getText().toString()+" "+username);
        Password.setText(Password.getText().toString()+" "+password);
        Branch.setText(Branch.getText().toString()+" "+branch);
        Gender.setText(Gender.getText().toString()+" "+gender);
        City.setText(City.getText().toString()+" "+city);
        Status.setText(Status.getText().toString()+" "+status);
    }
}