package com.example.demo;


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
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    //Columns 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "student_id")

    private int id;
    
    @Column(name = "student_name")
    private String name;
    
   @Column(name = "student_address")
   private String address;
   
    @Column(name = "student_email")
   private String email;
    
     @Column(name = "student_password")
   private String password;


   public Student(String name, String address, String email, String password) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.password = password;
}
}
