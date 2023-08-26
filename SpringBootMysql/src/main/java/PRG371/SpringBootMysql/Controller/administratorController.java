/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Controller;

import PRG371.SpringBootMysql.Entity.administrator;
import PRG371.SpringBootMysql.Service.administratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izak Du plooy
 */
@RestController
public class administratorController {
    @Autowired
    private administratorService adminservice;
    
    @PostMapping("/addAdmin")
    public administrator postDetials(@RequestBody administrator admin){
        return adminservice.saveDetails(admin);
    }    
}
