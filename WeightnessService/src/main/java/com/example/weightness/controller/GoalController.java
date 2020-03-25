package com.example.weightness.controller;

import com.example.weightness.DatabaseHelper;
import com.example.weightness.dto.ResponseCode;
import com.example.weightness.entity.Goal;
import com.example.weightness.entity.Result;
import com.example.weightness.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goal")
public class GoalController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseCode getGoal(@PathVariable String username) {
        logger.info("Get user goal info with : " + username);
        DatabaseHelper dbhelper = new DatabaseHelper();
        String weightness = dbhelper.getGoal(username);
        Goal goal = new Goal(username, weightness);
        return ResponseCode.ok("Searching sucessfully", goal);
    }

    @PostMapping(value="/", produces = "application/json")
    public ResponseCode save(@RequestBody Goal user) {
        logger.info("Save user goal info", user);
        DatabaseHelper dbhelper = new DatabaseHelper();
        dbhelper.setGoal(user.getUsername(), user.getWeightness());
        return ResponseCode.ok("Goal save successfully");
    }
}
