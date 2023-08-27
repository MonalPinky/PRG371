package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Long> {
    Student findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}