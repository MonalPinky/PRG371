package com.example.demo.dataacces;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Izak Du plooy
 */
@Entity 
@Data
@Table(name = "administrator")
@NoArgsConstructor
@AllArgsConstructor
public class administrator {
     //Columns 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "Admin_id")

    private int id;
    
    @Column(name = "Admin_name")
    private String name;
    
   @Column(name = "password")
   private String password;
   
    @Column(name = "contact")
   private String contact;
    
     
}
