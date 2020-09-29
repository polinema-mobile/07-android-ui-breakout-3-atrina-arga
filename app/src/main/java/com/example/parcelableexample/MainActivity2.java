package com.example.parcelableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.parcelableexample.model.Student;

public class MainActivity2 extends AppCompatActivity {
    TextView txtName, txtNIM, txtDOB, txtGender, txtMajor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Student std = getIntent().getParcelableExtra("std");
        txtName.setText(std.getName());
        txtNIM.setText(std.getNim());
        txtGender.setText(std.getGender());
        txtDOB.setText(std.getDob());
        txtMajor.setText(std.getMajor());

    }
    public void init(){
        txtName = findViewById(R.id.txtName);
        txtNIM = findViewById(R.id.txtNIM);
        txtDOB = findViewById(R.id.txtDOB);
        txtGender = findViewById(R.id.txtGender);
        txtMajor = findViewById(R.id.txtMajor);
    }
}