package com.example.demopackage.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PackageRequest {
    private String packageName;
    private Integer price;
    private Integer amount;
    private Date create_time;
}
