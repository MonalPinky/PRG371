/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG371.SpringBootMysql.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Izak Du Plooy
 */
@Entity 
@Data
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
public class register {
       //Columns 
    @Id
    @Column(name = "register_id")
    @GeneratedValue
    private int id;
    
    @Column(name = "student_name")
    private String name;
    
   @Column(name = "student_address")
   private String address;
   
    @Column(name = "student_email")
   private String email;
    
       @Column(name = "student_password")
   private String password;
       
          @Column(name = "course_name")
   private String course;
    
}
