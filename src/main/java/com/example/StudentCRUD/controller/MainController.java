package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.models.Students;
import com.example.StudentCRUD.service.StudentService;
import com.example.StudentCRUD.util.CustomErrorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class MainController {


    @Autowired
    StudentService studentService;

    // -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Students>> listAllUsers() {
        List<Students> students = studentService.findAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Students>>(students, HttpStatus.OK);
    }

    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {

        Students students = studentService.findById(id);
        if (students == null) {

            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Students>(students, HttpStatus.OK);
    }


    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Students students, UriComponentsBuilder ucBuilder) {


        if (studentService.isUserExist(students)) {
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    students.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        studentService.saveStudent(students);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/crud/user/{id}").buildAndExpand(students.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Students students) {


        Students currentUser = studentService.findById(id);

        if (currentUser == null) {

            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentUser.setName(students.getName());
        currentUser.setEmail(students.getEmail());
        currentUser.setAge(students.getAge());
        currentUser.setAddress(students.getAddress());
        currentUser.setContact(students.getContact());


        studentService.updateStudent(currentUser);
        return new ResponseEntity<Students>(currentUser, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

        Students students = studentService.findById(id);
        if (students == null) {
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<Students>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Students> deleteAllUsers() {


        studentService.deleteAllStudents();
        return new ResponseEntity<Students>(HttpStatus.NO_CONTENT);
    }


}
