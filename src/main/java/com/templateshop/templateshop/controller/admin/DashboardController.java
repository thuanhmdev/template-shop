package com.templateshop.templateshop.controller.admin;

import com.templateshop.templateshop.service.UserService;
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
