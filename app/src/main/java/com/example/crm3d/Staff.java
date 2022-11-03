package com.example.crm3d;

public class Staff {

    String name;
    String email ;

    String phone ;
    String dob ;
    String qualification ;
    String address ;

    public Staff(String name, String email, String phone, String dob, String qualification, String address ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.qualification = qualification;
        this.address = address;


    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }

    public String getQualification() {
        return qualification;
    }

    public String getAddress() {
        return address;
    }
}
