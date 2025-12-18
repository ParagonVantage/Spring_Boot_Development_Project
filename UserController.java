package com.example.springdemo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // CREATE user
    @PostMapping
    public User createUser(@RequestBody User user) {
        user = new User(UserData.nextId++, user.getName(), user.getEmail());
        UserData.users.add(user);
        return user;
    }

    // READ all users
    @GetMapping
    public List<User> getAllUsers() {
        return UserData.users;
    }

    // READ one user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return UserData.users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // UPDATE user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        for (User user : UserData.users) {
            if (user.getId().equals(id)) {
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                return user;
            }
        }
        return null;
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserData.users.removeIf(u -> u.getId().equals(id));
        return "User deleted!";
    }
}
