package com.example.api.controller;

import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.UserDTO;
import com.example.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
//@CrossOrigin(origins = "http://localhost:5173")
@Validated
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<GeneralResponseDTO> getAllUsers() {
        return ResponseEntity.ok( userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<GeneralResponseDTO>  createUser(@RequestBody @Valid UserDTO user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO>  updateUserById(@PathVariable Long id, @RequestBody @Valid UserDTO user) {
        return ResponseEntity.ok( userService.updateUserById(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok( userService.deleteUserById(id));
    }
}
