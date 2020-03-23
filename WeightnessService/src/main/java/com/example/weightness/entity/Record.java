package com.example.weightness.entity;

import lombok.Data;

import java.util.Date;
import java.util.TreeMap;

@Data
public class Record {
    private TreeMap<Date, String> treeMap;

    public Record(TreeMap<Date, String> treeMap) {
        this.treeMap = treeMap;
    }
}
