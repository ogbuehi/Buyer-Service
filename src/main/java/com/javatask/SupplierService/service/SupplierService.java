package com.javatask.SupplierService.service;

import com.javatask.SupplierService.dto.QueryDto;
import com.javatask.SupplierService.dto.SignUpDto;
import com.javatask.SupplierService.dto.SupplierResponse;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<String> saveSupplier(SignUpDto signUpDto);
    ResponseEntity<SupplierResponse> getSpecificSuppliers(int pageNum, int pageSize, QueryDto queryDto);
}
