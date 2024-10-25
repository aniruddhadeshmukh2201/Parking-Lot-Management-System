package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private String id;
    private String createdAt;
    private String updatedAt;
    private boolean isDeleted;
}