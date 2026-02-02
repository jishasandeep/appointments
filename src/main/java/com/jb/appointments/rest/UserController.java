package com.jb.appointments.rest;

import com.jb.appointments.model.User;
import com.jb.appointments.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/api/users")
@Tag(name="User Service Apis", description = "Operation related to users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("executing getAllUsers!");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        System.out.println("executing getUserById!");
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        return userService.findById(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}