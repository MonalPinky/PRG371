package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Izak Du plooy
 */
@Service
public class StudentService {
    @Autowired
    private IStudentRepo studentRepo;
    
    //Insert into db 
    public Student saveDetails(Student student){
        
        return studentRepo.save(student);
    }
}
