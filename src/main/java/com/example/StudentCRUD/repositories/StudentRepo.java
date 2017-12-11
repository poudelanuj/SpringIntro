package com.example.StudentCRUD.repositories;

import com.example.StudentCRUD.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends JpaRepository<Students,Integer> {
    Students findByName(String name);
}
