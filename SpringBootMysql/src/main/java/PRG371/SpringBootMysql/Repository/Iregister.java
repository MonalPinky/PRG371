/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PRG371.SpringBootMysql.Repository;

import PRG371.SpringBootMysql.Entity.register;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Thoth
 */
public interface Iregister extends JpaRepository<register,Integer> {
    
}
