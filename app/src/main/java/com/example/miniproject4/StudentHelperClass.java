package com.example.miniproject4;

public class StudentHelperClass {

    String name, reg_no, email, branch, gender, semester;

    public StudentHelperClass() {

    }

    public StudentHelperClass(String name, String reg_no, String email, String branch, String semester, String gender) {
        this.name = name;
        this.reg_no = reg_no;
        this.email = email;
        this.branch = branch;
        this.semester = semester;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
