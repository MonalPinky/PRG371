/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Service;

import PRG371.SpringBootMysql.Entity.Student;
import PRG371.SpringBootMysql.Repository.IStudentRepo;
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
