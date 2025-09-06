package com.example.CRUD.controllers;

import com.example.CRUD.models.UserModel;
import com.example.CRUD.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public UserModel setUser(@RequestBody UserModel user) {
        return this.userService.setUser(user);
    }

    @GetMapping("/{id}")
    public Optional getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping
    public UserModel updateUser(@RequestBody UserModel request, @PathVariable Long id) {
        return this.userService.updateUser(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Usuario con el "+ id + " ha sido eliminado";
        }else {
            return "Usuario con el "+ id + " no ha sido encontrado";
        }
    }
}
