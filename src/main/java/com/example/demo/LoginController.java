package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedInStudent")
public class LoginController {

    @GetMapping("/")
    public String greeting(Model model) {
        
        return "login";
    }
    
    @GetMapping("/error")
    public String handleError(Model model) {
     
        return "error"; 
    }


     @Autowired
    private IStudentRepo studentRepository; 
  @Autowired
    private Iregister registerRepository; 


    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
    @RequestParam("password") String password,
    Model model) {
        Student student = studentRepository.findByEmailAndPassword(email, password);
        
        if (student != null) {
            model.addAttribute("loggedInStudent", student); 
            
            if(student.getEmail().contains("@admin")){
                return "redirect:/admindashboard"; 
            }else{
                return "redirect:/dashboard"; 
            }
            
        } else {
            return "redirect:/error"; 
        }
    }

      @PostMapping("/register")
    public String register(@ModelAttribute("registration") register registration,
                           @ModelAttribute("loggedInStudent") Student loggedInStudent) {
       
        registration.setName(loggedInStudent.getName());
        registration.setAddress(loggedInStudent.getAddress());
        registration.setEmail(loggedInStudent.getEmail());
        registration.setPassword(loggedInStudent.getPassword());
        
        registerRepository.save(registration); 
        
        return "redirect:/dashboard"; 
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
      
        if (!model.containsAttribute("loggedInStudent")) {
            return "redirect:/"; 
        }
        
        model.addAttribute("registration", new register()); 
        return "dashboard";
    }

        @GetMapping("/admindashboard")
    public String admindashboardPage(Model model) {
       
        if (!model.containsAttribute("loggedInStudent")) {
            return "redirect:/";
        }
        
       
        return "admindashboard";
    }


    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam("name") String name,
                              @RequestParam("address") String address,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password) {
        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setEmail(email);
        student.setPassword(password);
        
        studentRepository.save(student);
    
        return "redirect:/"; 
    }
}