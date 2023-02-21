package com.example.demopackage.dto;

import com.example.demopackage.entities.PackageEntity;
import lombok.Data;

import java.util.Date;

@Data
public class PackageDto {
    private int id;
    private String package_name;
    private Integer price_per_unit;
    private Integer amount;
    private Date create_time;
    private Date modify_date;

    public PackageDto(PackageEntity packageEntity){
        this.id = packageEntity.getId();
        this.package_name = packageEntity.getPackage_name();
        this.price_per_unit = packageEntity.getPrice_per_unit();
        this.amount = packageEntity.getAmount();
        this.create_time = packageEntity.getCreate_date();
        this.modify_date = packageEntity.getModify_date();

    }
}
