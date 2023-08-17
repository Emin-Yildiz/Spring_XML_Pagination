package com.example.xml.controller;

import com.example.xml.domain.User;
import com.example.xml.model.UserDto;
import com.example.xml.model.response.GenericPagedDto;
import com.example.xml.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/xml")
    public ResponseEntity<List<User>> getUsersFromXml(){
        return new ResponseEntity<>(userService.getUsersFromXml(), HttpStatus.OK);
    }

    @GetMapping("/db")
    public ResponseEntity<List<User>> getUsersFromDb(){
        return new ResponseEntity<>(userService.getUsersFromDb(),HttpStatus.OK);
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<GenericPagedDto<User>> getUsersPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
        return new ResponseEntity<>(userService.findUserWithPagination(pageNumber,pageSize),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addUsers(){
        return new ResponseEntity<>(userService.addReadUsersFromXml(UserService.getUserList()), HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<List<User>> addUsersFromFile(@RequestParam MultipartFile file){
        return new ResponseEntity<>(userService.addUsersFromFile(file),HttpStatus.CREATED);
    }

    @DeleteMapping()
    public void deleteAll(){
        userService.deleteAll();
    }

}
