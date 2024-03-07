package test.security.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.security.task.services.UserService;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("users", userService.getAll());
        return "main";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}
