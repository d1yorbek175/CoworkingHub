package org.example.coworkhub.controller;

import org.example.coworkhub.dto.UserDto;
import org.example.coworkhub.model.Result;
import org.example.coworkhub.model.User;
import org.example.coworkhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public Result add(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping
    public List<User> all() {
        return userService.getall();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
