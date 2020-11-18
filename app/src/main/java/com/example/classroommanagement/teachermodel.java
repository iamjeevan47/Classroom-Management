package com.example.classroommanagement;

public class teachermodel 
{
    private String name;
    private String designation;
    private String phone;
    private String email;

    public teachermodel() { }

    private teachermodel(String teachername, String teacherdesig, String teacherphone, String teacheremail)
    {
        this.name = teachername;
        this.designation = teacherdesig;
        this.phone = teacherphone;
        this.email = teacheremail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
