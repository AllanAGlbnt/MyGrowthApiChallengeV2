package com.allanAsc.MyGrowthApiChallengeV2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Value("${admin.password}")
    private String password;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the given username.");
        }

        return new MyUserDetails(user);
    }

    // Method to create table
    public void createTable() {
        String admin = "admin";
        Role adminRole = new Role();
        adminRole.setId(4);
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedAdminPassword = passwordEncoder.encode(password);

        // Call the saveAll() method with a list of entities to insert data into the table
        repo.save(new User(1L, admin, admin, admin, encodedAdminPassword, true, roles));
    }

}
