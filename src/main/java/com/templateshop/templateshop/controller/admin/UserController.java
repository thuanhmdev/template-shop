package com.templateshop.templateshop.controller.admin;

import com.templateshop.templateshop.model.User;
import com.templateshop.templateshop.service.RoleService;
import com.templateshop.templateshop.service.UploadService;
import com.templateshop.templateshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final UploadService uploadService;


    public UserController(UserService userService, RoleService roleService, UploadService uploadService) {
        this.userService = userService;
        this.roleService = roleService;
        this.uploadService = uploadService;

    }

    @GetMapping("")
    public String getUserPage(Model model, @RequestParam("page") Optional<String> pageOptional, @RequestParam("pageSize") Optional<String> pageSizeOptional) {
        int page = pageOptional.map(Integer::parseInt).orElse(1);
        int pageSize = pageSizeOptional.map(Integer::parseInt).orElse(10);

        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<User> usersPage = this.userService.getAllUsers(pageable);
        List<User> users = usersPage.getContent();
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", usersPage.getTotalPages());
        return "admin/user/index";
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable String id) {
        User userDetail = this.userService.getUserById(id);
        model.addAttribute("user", userDetail);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", this.roleService.getAllRole());
        return "admin/user/create";
    }


    @PostMapping("/create")
    public String createUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult newUserBindingResult, @RequestParam("file") MultipartFile file) {

        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }
        String avatarPath = this.uploadService.handleSaveUploadFile(file, "avatar");
        newUser.setAvatar(avatarPath);
        this.userService.createUser(newUser);

        return "redirect:/admin/user/create";
    }

    @GetMapping("/update/{id}")
    public String getUpdateUserPage(@PathVariable String id, Model model) {
        User currentUser = this.userService.getUserById(id);
        if (currentUser == null)
            return "redirect:/admin/user";
        model.addAttribute("userUpdate", currentUser);
        model.addAttribute("roles", this.roleService.getAllRole());
        return "/admin/user/update";
    }

    @PostMapping("/update")
    public String handleUpdateUser(@ModelAttribute("userUpdate") @Valid User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser == null) {
            return "redirect:/admin/user";
        }
        this.userService.updateUser(currentUser, user);
        return "redirect:/admin/user";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteUserPage(@PathVariable String id, Model model) {
        User currentUser = this.userService.getUserById(id);
        if (currentUser == null)
            return "redirect:/admin/user";
        model.addAttribute("id", id);
        model.addAttribute("currentUser", currentUser);
        return "/admin/user/delete";
    }

    @PostMapping("/delete")
    public String handleDeleteUser(@ModelAttribute("currentUser") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser == null) {
            return "redirect:/admin/user";
        }
        this.userService.deleteUser(user.getId());
        return "redirect:/admin/user";
    }
}
