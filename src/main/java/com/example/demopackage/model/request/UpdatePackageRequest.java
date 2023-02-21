package com.example.demopackage.model.request;

import lombok.Data;

@Data
public class UpdatePackageRequest {
    private String name;
    private Integer price;
    private Integer amount;
}
