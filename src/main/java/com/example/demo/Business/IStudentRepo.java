package com.example.demo.Business;
import com.example.demo.dataacces.Student;
import com.example.demo.dataacces.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Long> {
    Student findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}