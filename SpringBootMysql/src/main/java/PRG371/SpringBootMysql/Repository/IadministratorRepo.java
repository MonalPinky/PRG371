/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PRG371.SpringBootMysql.Repository;

import PRG371.SpringBootMysql.Entity.administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Thoth
 */
public interface IadministratorRepo extends JpaRepository<administrator,Integer> {
    
}
