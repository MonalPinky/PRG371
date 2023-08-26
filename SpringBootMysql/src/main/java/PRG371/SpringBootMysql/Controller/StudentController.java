/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Controller;

import PRG371.SpringBootMysql.Entity.Student;
import PRG371.SpringBootMysql.Service.StudentService;
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
