package com.example.StudentCRUD.repositories;

import com.example.StudentCRUD.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);

    List<Student> findByAgeAfter(int age);

    List<Student> findByNameAndAddress(String name,String address);

    Student findByEmail(String email);




}
