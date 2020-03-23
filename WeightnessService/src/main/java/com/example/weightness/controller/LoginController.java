package com.example.weightness.controller;

import com.example.weightness.DatabaseHelper;
import com.example.weightness.dto.ResponseCode;
import com.example.weightness.entity.Result;
import com.example.weightness.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/", produces = "application/json")
    public ResponseCode ifloginValid(@RequestBody User user) {
        logger.info("Get user login info with : " + user.getUsername());
        DatabaseHelper dbhelper = new DatabaseHelper();
        boolean isValid = dbhelper.ifLoginValid(user.getUsername(), user.getPassword());
        Result res = new Result(isValid);
        return ResponseCode.ok("Searching sucessfully", res);
    }
}
