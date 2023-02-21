package com.example.demopackage.dto;

import com.example.demopackage.entities.PackageEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UpdatePackageDto {
    private String package_name;
    private Integer price_per_unit;
    private Integer amount;
    private Date create_time;
    private Date modify_date;

    public UpdatePackageDto(PackageEntity packageEntity){
        this.package_name = packageEntity.getPackage_name();
        this.price_per_unit = packageEntity.getPrice_per_unit();
        this.amount = packageEntity.getAmount();
        this.create_time = packageEntity.getCreate_date();
        this.modify_date = new Date();
    }
}
