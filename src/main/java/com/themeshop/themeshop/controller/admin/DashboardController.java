package com.themeshop.themeshop.controller.admin;

import com.themeshop.themeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
private final UserService userService;
    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model){

        model.addAttribute("countUser", this.userService.countUsers());
        return "admin/dashboard/index";
    }
}
