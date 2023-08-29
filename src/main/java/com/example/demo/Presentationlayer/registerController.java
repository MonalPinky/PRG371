package com.example.demo.Presentationlayer;

import com.example.demo.Business.registerService;
import com.example.demo.dataacces.register;
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
