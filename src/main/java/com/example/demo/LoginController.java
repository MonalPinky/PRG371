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

    @GetMapping("/invalid")
    public String invalid(Model model) {

        return "invalid";
    }

 
    @Autowired
    private IStudentRepo studentRepository;
    @Autowired
    private Iregister registerRepository;
    @Autowired
    private IadministratorRepo adminRepository;

    @PostMapping("/login")
public String login(@RequestParam("email") String email,
                    @RequestParam("password") String password,
                    Model model) {

    // Check for student
    Student student = studentRepository.findByEmailAndPassword(email, password);
    
    if (student != null) {
        try {
            model.addAttribute("loggedInStudent", student);
            return "redirect:/dashboard";
        } catch (Exception e) {
            return "redirect:/invalid";
        }
    } else {
        // Check for administrator
        administrator admin = adminRepository.findByContactAndPassword(email, password);

        if (admin != null) {
            return "redirect:/admindashboard";
        } else {
            return "redirect:/invalid";
        }
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
      
        if (studentRepository.existsByEmail(email)) {
            
            return "redirect:/error"; 
        }
    
        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setEmail(email);
        student.setPassword(password);
    
        studentRepository.save(student);
    
        return "redirect:/";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestParam("name") String name,
                            @RequestParam("contact") String contact,
                            @RequestParam("password") String password) {
     
        if (adminRepository.existsByContact(contact)) {
         
            return "redirect:/error"; 
        }
    
        administrator administrator = new administrator();
        administrator.setName(name);
        administrator.setContact(contact);
        administrator.setPassword(password);
    
        adminRepository.save(administrator);
    
        return "redirect:/";
    }
}