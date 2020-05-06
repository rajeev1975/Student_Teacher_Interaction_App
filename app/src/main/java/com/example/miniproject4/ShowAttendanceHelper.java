package com.example.miniproject4;

public class ShowAttendanceHelper {
    String date, attendance;

    public ShowAttendanceHelper() {
    }

    public ShowAttendanceHelper(String attendance, String date) {
        this.date = date;
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
