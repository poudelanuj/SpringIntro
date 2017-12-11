package com.example.StudentCRUD.service;

import com.example.StudentCRUD.models.Students;

import java.util.List;

public interface StudentService {

    Students findById(int id);

    Students findByName(String name);

    void saveStudent(Students students);

    void updateStudent(Students students);

    void deleteStudentById(int id);

    void deleteAllStudents();

    List<Students> findAllStudents();

    boolean isUserExist(Students students);

}
