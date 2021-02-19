package org.launchcode.spaday.controllers;


import org.launchcode.spaday.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "/user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {
        // add form submission handling code here
        if(user.getPassword().equals(verifyPassword)) {
            model.addAttribute("user", user);
            return "/user/index";
        }
        model.addAttribute("error", "Your passwords do not match");
        model.addAttribute("user", user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "/user/add";
    }

}
