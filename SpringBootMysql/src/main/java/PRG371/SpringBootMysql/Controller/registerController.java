/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Controller;
import PRG371.SpringBootMysql.Entity.administrator;
import PRG371.SpringBootMysql.Entity.register;
import PRG371.SpringBootMysql.Service.administratorService;
import PRG371.SpringBootMysql.Service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izak DU plooy
 */
@RestController
public class registerController {
     @Autowired
    private registerService registerService1;
    //Insert
    @PostMapping("/addRegister")
    public register postDetials(@RequestBody register register){
        return registerService1.saveDetails(register);
    }    
}
