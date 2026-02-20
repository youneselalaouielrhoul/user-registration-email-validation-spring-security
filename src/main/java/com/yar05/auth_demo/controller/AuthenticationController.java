package com.yar05.auth_demo.controller;

import com.yar05.auth_demo.entity.User;
import com.yar05.auth_demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("register")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("success", "Please confirm your email address");
        return "redirect:/register";
    }

    @GetMapping("/confirmToken")
    public String confirmToken(@RequestParam("token") String token, Model model) {
        userService.confirmToken(token);
        return "confirmToken";
    }
}
