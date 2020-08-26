package com.example.classroommanagement;

import com.google.firebase.auth.FirebaseAuth;

public class Userdata
{
    public Userdata()
    {

    }
    String name;
    String email;
    String phone;
    String username;
    String password;
    String cpassword;
//    String uid;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

//    public String getUid() {
//        return uid;
//    }
//    public void setUid(String uid) {
//        this.uid = uid;
//    }

    public Userdata(String name,String email,String phone,String username, String password, String cpassword)
    {
        this.name=name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.cpassword = cpassword;
//        this.uid = FirebaseAuth.getInstance().getUid();
    } //Admin

}
