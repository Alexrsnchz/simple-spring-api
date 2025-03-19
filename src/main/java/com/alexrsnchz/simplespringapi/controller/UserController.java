package com.alexrsnchz.simplespringapi.controller;

import com.alexrsnchz.simplespringapi.model.User;
import com.alexrsnchz.simplespringapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User storedUser = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(storedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
