package com.example.parcelableexample.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String name, nim, dob, gender, major;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.nim);
        dest.writeString(this.dob);
        dest.writeString(this.gender);
        dest.writeString(this.major);
    }

    public Student() {
    }

    public Student(String name, String nim, String dob, String gender, String major) {
        this.name = name;
        this.nim = nim;
        this.dob = dob;
        this.gender = gender;
        this.major = major;
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.nim = in.readString();
        this.dob = in.readString();
        this.gender = in.readString();
        this.major = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getMajor() {
        return major;
    }
}
