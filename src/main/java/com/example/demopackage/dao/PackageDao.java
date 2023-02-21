package com.example.demopackage.dao;

import com.example.demopackage.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends JpaRepository<PackageEntity, Integer> , JpaSpecificationExecutor<PackageEntity> {
    @Query("select pc from PackageEntity pc where pc.package_name =:name ")
    PackageEntity findByName(@Param("name") String name);

}
