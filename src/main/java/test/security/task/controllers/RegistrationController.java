package test.security.task.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import test.security.task.entities.UserEntity;
import test.security.task.services.UserService;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") @Valid UserEntity userEntity, Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";

    }
}
