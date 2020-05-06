package com.example.miniproject4;

public class StoreAttendance {
    String attendance, date;

    public StoreAttendance() {
    }

    public StoreAttendance(String date, String attendance) {
        this.attendance = attendance;
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
