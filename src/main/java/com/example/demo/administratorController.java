package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 *
 * @author Izak Du plooy
 */
@Controller
public class administratorController {
   
    @Autowired
    private IStudentRepo studentRepository;
    
    @Autowired
    private Iregister registerRepository;


         @Autowired
    private administratorService administratorService;
    //Insert
    @PostMapping("/addAdmin")
    public administrator postDetials(@RequestBody administrator administrator){
        return administratorService.saveDetails(administrator);
    }    

        @GetMapping("/addstudent")
    public String addstudent() {
        return "addstudent";
    }

    @PostMapping("/addStudentExec")
    public String addStudentExec(@RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password) {
        Student student = new Student(name, address, email, password);
        studentRepository.save(student);
        
        return "redirect:/admindashboard";
    }
    
    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") Long id) {

         Optional<Student> student = studentRepository.findById(id);

          if (student.isPresent()) {
          studentRepository.deleteById(id);
          return "redirect:/admindashboard";
        }
      
          return "redirect:/admindashboard";
      
    }
    
      
    @PostMapping("/deleteRegister")
    public String deleteRegister(@RequestParam("id") int id) {

         Optional<register> reg = registerRepository.findById(id);

          if (reg.isPresent()) {
          registerRepository.deleteById(id);
          return "redirect:/admindashboard";
        }
      
          return "redirect:/admindashboard";
      
    }
    
   
    
    @PostMapping("/editStudent")
    public String editStudent(@RequestParam("id") Long id,
                              Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "editstudent";
        }
        
        return "redirect:/admindashboard";
    }

    @GetMapping("/addRegisterPage")
    public String addRegisterPage() {
        return "registerCourse";
    }
    
    @PostMapping("/addRegisterCourse")
    public String addRegister(@RequestParam("course") String course,
                              @RequestParam("studentName") String studentName,
                              @RequestParam("studentAddress") String studentAddress,
                              @RequestParam("studentEmail") String studentEmail,
                              @RequestParam("studentPassword") String studentPassword) {
        register register = new register(course, studentName, studentAddress, studentEmail, studentPassword);
        register.setName(studentName);
        register.setAddress(studentAddress);
        register.setEmail(studentEmail);
        register.setCourse(course);
        register.setPassword(studentPassword);
            
        
  
        registerRepository.save(register);
        
        return "redirect:/admindashboard";
    }

    @PostMapping("/editRegister")
    public String editRegister(@RequestParam("id") int id,
                                Model model) {
        Optional<register> register = registerRepository.findById(id);
        if (register.isPresent()) {
            model.addAttribute("register", register.get());
            return "editRegisterCourse";
        }
        
        return "redirect:/admindashboard";
    }
    
    @PostMapping("/saveEditedRegister")
    public String saveEditedRegister(@RequestParam("id") int id,
                                     @RequestParam("course") String course,
                                     @RequestParam("name") String name,
                                     @RequestParam("address") String address,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        Optional<register> optionalRegister = registerRepository.findById(id);
        if (optionalRegister.isPresent()) {
            register register = optionalRegister.get();
            register.setCourse(course);
            register.setName(name);
            register.setAddress(address);
            register.setEmail(email);
            register.setPassword(password);
          
            
            registerRepository.save(register);
        }
        
        return "redirect:/admindashboard";
    }

    @PostMapping("/saveEditedStudent")
    public String saveEditedStudent(@RequestParam("id") Long id,
                                    @RequestParam("name") String name,
                                    @RequestParam("address") String address,
                                    @RequestParam("email") String email,
                                    @RequestParam("password") String password) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setAddress(address);
            student.setEmail(email);
            student.setPassword(password);
            
            studentRepository.save(student);
        }
        
        return "redirect:/admindashboard";
    }


  
}
