/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Service;

import PRG371.SpringBootMysql.Entity.register;
import PRG371.SpringBootMysql.Repository.Iregister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Izak Du plooy
 */
@Service
public class registerService {
    @Autowired
    private Iregister  iregister;
    
     public register saveDetails(register register){
        
        return iregister.save(register);
    }
}
