package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository layer for Student database operations.
 * JpaRepository provides built-in CRUD methods automatically.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
