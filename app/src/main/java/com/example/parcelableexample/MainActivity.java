package com.example.parcelableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.parcelableexample.model.Student;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity{
    private EditText txtName, txtNIM, txtDOB;
    private Spinner dropdown;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private String selectedGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (rgGender.getCheckedRadioButtonId()){
                    case R.id.rbMale:
                        if(rbMale.isChecked()){
                        rbFemale.setChecked(false);
                        selectedGender = rbMale.getText().toString();}
                        break;
                    case R.id.rbFemale:
                        if(rbFemale.isChecked()){
                        rbMale.setChecked(false);
                        selectedGender = rbFemale.getText().toString();}
                        break;
                }
            }
        });
    }
    public void saveClick(View v){
        String name = txtName.getText().toString();
        String nim = txtNIM.getText().toString();
        String dob = txtDOB.getText().toString();
        String major = dropdown.getSelectedItem().toString();
        String gender = selectedGender;
        Student std = new Student(name, nim,dob,gender,major);
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("std",std);
        startActivity(i);
    }

    public void dateClick(View v) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
                            txtDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
    }

    public void init(){
        txtName = (EditText) findViewById(R.id.txtName);
        txtNIM = (EditText)findViewById(R.id.txtNim);
        txtDOB = (EditText)findViewById(R.id.txtDOB);
        dropdown = (Spinner)findViewById(R.id.spinnerDropdown);
        rgGender = (RadioGroup)findViewById(R.id.rgGender);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton)findViewById(R.id.rbFemale);
    }

}