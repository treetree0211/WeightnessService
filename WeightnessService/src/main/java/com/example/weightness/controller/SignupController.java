package com.example.weightness.controller;

import com.example.weightness.DatabaseHelper;
import com.example.weightness.dto.ResponseCode;
import com.example.weightness.entity.Result;
import com.example.weightness.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseCode ifUseranmeValid(@PathVariable String username) {
        logger.info("Get user login info with : " + username);
        DatabaseHelper dbhelper = new DatabaseHelper();
        boolean ifExist = dbhelper.ifUserExist(username);
        Result res = new Result(ifExist);
        return ResponseCode.ok("Searching sucessfully", res);
    }

    @PostMapping(value="/", produces = "application/json")
    public ResponseCode save(@RequestBody User user) {
        logger.info("Save user login info", user);
        DatabaseHelper dbhelper = new DatabaseHelper();
        dbhelper.userSignUp(user.getUsername(), user.getPassword());
        return ResponseCode.ok("Save successfully");
    }
}
