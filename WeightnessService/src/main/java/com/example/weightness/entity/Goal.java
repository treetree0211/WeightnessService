package com.example.weightness.entity;

import lombok.Data;

@Data
public class Goal {
    private String weightness;

    public Goal (String weightness) {
        this.weightness = weightness;
    }
}
