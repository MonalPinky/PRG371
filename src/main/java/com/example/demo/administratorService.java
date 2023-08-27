package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Izak Du Plooy
 */
@Service
public class administratorService {
    @Autowired
    private IadministratorRepo administratorrepo;
    
    public administrator saveDetails(administrator admin){
        return administratorrepo.save(admin);
    }
}
