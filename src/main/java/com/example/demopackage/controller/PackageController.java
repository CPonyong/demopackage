package com.example.demopackage.controller;

import com.example.demopackage.dto.PackageDto;
import com.example.demopackage.dto.UpdatePackageDto;
import com.example.demopackage.jwt.security.UserCredentials;
import com.example.demopackage.model.request.PackageRequest;
import com.example.demopackage.model.request.UpdatePackageRequest;
import com.example.demopackage.model.resonse.ResponseObject;
import com.example.demopackage.services.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/packageManage")
public class PackageController {

    @Autowired
    IPackageService packageService;

    @PostMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<List<PackageDto>> searchPackage(@RequestBody PackageRequest req){
       return new ResponseObject<>(packageService.search(req));
    }

    @PostMapping(path = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<PackageDto> insertPackage(@RequestBody PackageRequest packageRequest) throws Exception {
        return  new ResponseObject<>(packageService.insert(packageRequest));
    }

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<UpdatePackageDto> updatePackage(@RequestBody UpdatePackageRequest request) throws  Exception{
       return new ResponseObject<>(packageService.update(request));
    }

    @PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePackage(@RequestBody PackageRequest req) throws Exception {
        return packageService.delete(req);
    }

}
