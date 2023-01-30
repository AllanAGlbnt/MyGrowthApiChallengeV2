package com.allanAsc.MyGrowthApiChallengeV2.controller;

import com.allanAsc.MyGrowthApiChallengeV2.user.Role;
import com.allanAsc.MyGrowthApiChallengeV2.user.RoleRepository;
import com.allanAsc.MyGrowthApiChallengeV2.user.User;
import com.allanAsc.MyGrowthApiChallengeV2.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public MainController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/admin/login")
    public String viewAdminLoginPage() {
        return "admin/admin_login";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "admin/admin_home";
    }

    @GetMapping("/user/login")
    public String viewuserLoginPage() {
        return "user/user_login";
    }

    @GetMapping("/user/home")
    public String viewuserHomePage() {
        return "user/user_home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        Role role = roleRepository.findById(1).orElse(null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRoles(roleSet);
        userRepository.save(user);
        return "register_success";
    }
}
