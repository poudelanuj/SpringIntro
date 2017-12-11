package com.example.StudentCRUD.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students")
public class Students implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name="name")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="age")
    public int age;
    @Column(name="address")
    public String address;
    @Column(name="contact")
    public String contact;

    public Students() {
    }

    public Students(String name, String email, int age, String address, String contact) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
