package com.example.demo.Business;

import com.example.demo.dataacces.register;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Thoth
 */
public interface Iregister extends JpaRepository<register,Integer> {
    
}
