package com.example.weightness.entity;

import lombok.Data;

@Data
public class Goal {
    private String username;
    private String weightness;

    public Goal (String username, String weightness) {
        this.username = username;
        this.weightness = weightness;
    }

    public String getUsername() {
        return username;
    }

    public String getWeightness() {
        return weightness;
    }
}
