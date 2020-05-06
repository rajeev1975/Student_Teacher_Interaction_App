package com.example.miniproject4;

public class TeacherHelper {

    String name, deptNo, email, dept, gender;

    public TeacherHelper(String name, String deptNo, String email, String dept, String gender) {
        this.name = name;
        this.deptNo = deptNo;
        this.email = email;
        this.dept = dept;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
