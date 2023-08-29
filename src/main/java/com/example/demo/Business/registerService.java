package com.example.demo.Business;


import com.example.demo.dataacces.register;
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
