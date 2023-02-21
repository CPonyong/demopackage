package com.example.demopackage.services;

import com.example.demopackage.dto.PackageDto;
import com.example.demopackage.dto.UpdatePackageDto;
import com.example.demopackage.model.request.PackageRequest;
import com.example.demopackage.model.request.UpdatePackageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPackageService {
    public List<PackageDto> search(PackageRequest req);
    public PackageDto insert(PackageRequest packageRequest) throws Exception;
    public UpdatePackageDto update(UpdatePackageRequest request) throws Exception;
    public ResponseEntity<String> delete(PackageRequest req) throws Exception;
}
