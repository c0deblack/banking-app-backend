package org.barp.backend.Controller;

import org.barp.backend.Model.User;
import org.barp.backend.Service.ServiceResult;
import org.barp.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
@RestController
public class UserController {
    UserService userService;

    @Autowired
    UserController(UserService userService){this.userService = userService;}
    @GetMapping("user")
    public ResponseEntity<List<User>> getAllUsers() { return this.userService.getAllUsers(); }
    @PostMapping("user")
    public ResponseEntity<?> addNewUser(@RequestBody User user) { return this.userService.addUser(user); }
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {return this.userService.findUserById(id);}
}
