package com.example.weightness.entity;

import lombok.Data;

@Data
public class Result {
    private boolean res;

    public Result(boolean res) {
        this.res = res;
    }
}
