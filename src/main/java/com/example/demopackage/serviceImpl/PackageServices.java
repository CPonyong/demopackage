package com.example.demopackage.serviceImpl;

import com.example.demopackage.dao.PackageDao;
import com.example.demopackage.dto.PackageDto;
import com.example.demopackage.dto.UpdatePackageDto;
import com.example.demopackage.entities.PackageEntity;
import com.example.demopackage.model.request.PackageRequest;
import com.example.demopackage.model.request.UpdatePackageRequest;
import com.example.demopackage.services.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PackageServices implements IPackageService {

    @Autowired
    PackageDao packageDao;

    @Override
    public List<PackageDto> search(PackageRequest req) {
        List<PackageEntity> queryPackage = packageDao.findAll(new Specification<PackageEntity>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<PackageEntity> root, CriteriaQuery<?> query,
                             CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(req.getPackageName())){
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("package_name")),
                            "%" + req.getPackageName().toLowerCase() + "%"));
                }
                if (req.getPrice() != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("price_per_unit"),req.getPrice())));
                }
                if (req.getCreate_time() != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("create_date"), req.getCreate_time())));
                }
                if (req.getAmount() != null){
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("amount"), req.getAmount())));
                }
                query.orderBy(criteriaBuilder.asc(root.get("package_name")));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });

        List<PackageDto> resultPackage = new ArrayList<>();
        for (PackageEntity resultPack : queryPackage){
            PackageDto packageDto = new PackageDto(resultPack);
            resultPackage.add(packageDto);
        }

        List<PackageDto> sortedResult = new ArrayList<>();
        for (int i = 0; i < resultPackage.size();i++){
            for (int j = 1; j < resultPackage.size()-i;j++){
                if (resultPackage.get(j-1).getAmount() > resultPackage.get(j).getAmount()){
                    Collections.swap(resultPackage, j-1, j);
                }
            }
        }

        System.out.println(resultPackage);

        return resultPackage;


    }

    @Override
    public PackageDto insert(PackageRequest packageRequest) throws Exception {
        if (StringUtils.isEmpty(packageRequest.getPackageName())){
            throw new Exception("Package name cannot be empty");
        }
        PackageEntity newPackage = new PackageEntity(packageRequest.getPackageName(), packageRequest.getPrice(), packageRequest.getAmount());
        packageDao.save(newPackage);
        return new PackageDto(newPackage);
    }

    @Override
    public UpdatePackageDto update(UpdatePackageRequest req) throws Exception {
        PackageEntity updatePackage = packageDao.findByName(req.getName());

        if (StringUtils.isNotEmpty(req.getName())){
            updatePackage.setPrice_per_unit(req.getPrice());
        }
        if (req.getAmount() != null){
            updatePackage.setAmount(req.getAmount());
        }
        if (req.getPrice() != null){
            updatePackage.setPrice_per_unit(req.getPrice());
        }

        packageDao.save(updatePackage);
        return new UpdatePackageDto(updatePackage);
    }

    @Override
    public ResponseEntity<String> delete(PackageRequest req) throws Exception {
        System.out.println(req.getPackageName());
        PackageEntity result = packageDao.findByName(req.getPackageName());
        if (result == null){
            throw new Exception("This package = " + req.getPackageName() + "not found");
        }
        packageDao.delete(result);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
