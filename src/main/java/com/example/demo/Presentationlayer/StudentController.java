package com.example.demo.Presentationlayer;

import com.example.demo.Business.StudentService;
import com.example.demo.dataacces.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *

 * @author Izak Du plooy
 */
@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentservce;
    
    @PostMapping("/addStudent")
    public Student postDetials(@RequestBody Student student){
        return studentservce.saveDetails(student);
    }
    
}