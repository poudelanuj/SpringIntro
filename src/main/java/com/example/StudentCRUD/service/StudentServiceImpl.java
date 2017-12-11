package com.example.StudentCRUD.service;


import com.example.StudentCRUD.models.Students;
import com.example.StudentCRUD.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Students findById(int id) {
        return studentRepo.findOne(id);
    }

    @Override
    public Students findByName(String name) {
        return  studentRepo.findByName(name);
    }

    @Override
    public void saveStudent(Students students) {
        studentRepo.save(students);

    }

    @Override
    public void updateStudent(Students students) {
        saveStudent(students);

    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.delete(id);

    }

    @Override
    public void deleteAllStudents() {
        studentRepo.deleteAll();
    }

    @Override
    public List<Students> findAllStudents() {
        return studentRepo.findAll();
    }

    public boolean isUserExist(Students students) {
        return findByName(students.getName()) != null;
    }
}
