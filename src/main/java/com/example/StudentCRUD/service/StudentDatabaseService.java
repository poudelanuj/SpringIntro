package com.example.StudentCRUD.service;

import com.example.StudentCRUD.models.Student;
import com.example.StudentCRUD.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentDatabaseService")
public class StudentDatabaseService {

    @Autowired
    StudentRepo studentRepo;

    public void saveStudent(Student students){
        studentRepo.save(students);
    }


    public void updateStudent(Student student){
        Student temp=studentRepo.findByEmail(student.getEmail());
        if(temp==null){
            studentRepo.save(student);
        }else{
            studentRepo.delete(temp);
            studentRepo.save(student);
        }

    }

    public List<Student> findByName(String name){
        return studentRepo.findByName(name);
    }

    public List<Student> findByNameAndAddress(String name,String address){
        return studentRepo.findByNameAndAddress(name,address);
    }

    public List<Student> findByAgeAfter(int age){
        return studentRepo.findByAgeAfter(age);
    }

    public List<Student> findAllStudent(){
        return studentRepo.findAll();
    }

}
