/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Service;

import PRG371.SpringBootMysql.Entity.administrator;
import PRG371.SpringBootMysql.Repository.IadministratorRepo;
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
