package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Services.UserService;
import com.rajat.BookMyShow.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateUserDTO createUserDTO) throws Exception {
        return ResponseEntity.ok(userService.AddUser(createUserDTO.getName(), createUserDTO.getEmail()));
    }
    @GetMapping()
    public ResponseEntity getUser(@PathVariable long userId){
        return ResponseEntity.ok("Success");
    }
}
