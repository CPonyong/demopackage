package com.example.demopackage.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "package", schema = "public")
public class PackageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "package_name")
    private String package_name;
    private int price_per_unit;
    private int amount;
    private Date create_date;
    private Date modify_date;

    public PackageEntity(String name, int price, int amount){
        this.package_name = name;
        this.price_per_unit = price;
        this.amount = amount;
        this.create_date = new Date();
    }

    public PackageEntity(int price, int amount){
        this.price_per_unit = price;
        this.amount = amount;
        this.modify_date = new Date();
    }

    public PackageEntity() {
    }
}
