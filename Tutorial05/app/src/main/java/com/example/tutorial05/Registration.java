package com.example.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    Button btnRegister;
    EditText fname,lname,uname,Password;
    Switch Branch;
    RadioGroup Gender;
    RadioButton selectedGender;
    Spinner City;
    CheckBox Status;
    int genderID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fname = findViewById(R.id.edtFirstname);
        lname = findViewById(R.id.edtLastname);
        uname = findViewById(R.id.edtUsername);
        Password = findViewById(R.id.edtPassword);
        Branch = findViewById(R.id.switchBranch);
        Gender = (RadioGroup) findViewById(R.id.genderButton);

        City = findViewById(R.id.spinner);
        Status = findViewById(R.id.checkBox);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }
     void checkDataEntered(){
        String firstname,lastname,username,password,branch,gender,city,status;
        int count=0;
         genderID = Gender.getCheckedRadioButtonId();
         selectedGender = findViewById(genderID);
        firstname = fname.getText().toString();
        lastname = lname.getText().toString();
        username = uname.getText().toString();
        password = Password.getText().toString();
        branch = !Branch.isChecked()?"CE":"IT";
        gender = selectedGender.getText().toString();
        city = City.getSelectedItem().toString();
        status = Status.isChecked()?"Active":"Inactive";

        if(isEmpty(fname)){
            Toast t = Toast.makeText(this,"You must enter Firstname",Toast.LENGTH_SHORT);
            t.show();
            count++;
        }
        if(isEmpty(lname)){
            Toast t = Toast.makeText(this,"You must enter Lastname",Toast.LENGTH_SHORT);
            t.show();
            count++;
        }
        if(isEmpty(uname)){
            Toast t = Toast.makeText(this,"You must enter email as Username",Toast.LENGTH_SHORT);
            t.show();
            count++;
        }
        if(isEmpty(Password)){
            Toast t = Toast.makeText(this,"You must enter password",Toast.LENGTH_SHORT);
            t.show();
            count++;
        }
        if(city.equals("Select City")){
            Toast t = Toast.makeText(this,"You must select city",Toast.LENGTH_SHORT);
            t.show();
            count++;
        }
        if(!isEmail(uname)){
            uname.setError("Please Enter valide email");
            Toast t = Toast.makeText(this,"Please Enter valid Email",Toast.LENGTH_SHORT);
            t.show();
        }else if(count==0){
            Intent intent = new Intent(Registration.this,Welcome.class);
            intent.putExtra("First_name",firstname);
            intent.putExtra("Last_name",lastname);
            intent.putExtra("User_name",username);
            intent.putExtra("Password",password);
            intent.putExtra("Branch",branch);
            intent.putExtra("Gender",gender);
            intent.putExtra("City",city);
            intent.putExtra("Status",status);
            startActivity(intent);
        }
     }
     boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
     }
     boolean isEmail(EditText text){
        CharSequence str = text.getText().toString();
        return (Patterns.EMAIL_ADDRESS.matcher(str).matches());
     }
}