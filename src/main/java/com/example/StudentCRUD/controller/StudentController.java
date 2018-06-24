package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.models.Student;
import com.example.StudentCRUD.service.StudentDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentController {

    @Autowired
    StudentDatabaseService studentDatabaseService;

    @PostMapping(value = "createStudent/")
    public void createStudent(@ModelAttribute  Student student){
        studentDatabaseService.saveStudent(student);
    }


    // url pattern :   localhost:8080/student/deleteStudent?name=xyz
    @GetMapping(value = "deleteStudent")
    public void deleteStudent(@RequestParam("name") String name){

    }

    //url pattern : localhost:8080/student/getStudent?name=xyz
    @GetMapping(value = "getStudent")
    public List<Student> getStudent(@RequestParam("name") String name){
        if(name.isEmpty()){
            throw new  IllegalArgumentException("Name field in empty");
        }
        List<Student> students=studentDatabaseService.findByName(name);

        return  students;
    }


    // url pattern: http://localhost:8080/student/getAllStudent
    @GetMapping(value = "getAllStudent")
    public List<Student> getAllStudents(){
        return studentDatabaseService.findAllStudent();
    }


    //url pattern : localhost:8080/student/nameAndAddress?name=xyz&address=abc
    @GetMapping(value = "nameAndAddress")
    public List<Student> getByNameAndAddress(@RequestParam("name")String name,@RequestParam("address") String address){
        return studentDatabaseService.findByNameAndAddress(name,address);
    }

    //url pattern : localhost:8080/student/ageAfter?age=1
    @RequestMapping(value = "ageAfter",method = RequestMethod.GET)
    public List<Student> findByAgeAfter(@RequestParam("age") int age){
        return studentDatabaseService.findByAgeAfter(age);
    }
}
