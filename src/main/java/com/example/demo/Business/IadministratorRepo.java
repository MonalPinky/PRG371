package com.example.demo.Business;

import com.example.demo.dataacces.administrator;
import com.example.demo.dataacces.administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Thoth
 */
public interface IadministratorRepo extends JpaRepository<administrator,Integer> {

    administrator findByContactAndPassword(String contact, String password);
  boolean existsByContact(String contact);
}
