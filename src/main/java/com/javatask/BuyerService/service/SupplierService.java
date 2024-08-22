package com.javatask.BuyerService.service;

import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import com.javatask.BuyerService.dto.SupplierSignUpDto;
import org.springframework.http.ResponseEntity;

public interface SupplierService {
    ResponseEntity<String> saveSupplier(SupplierSignUpDto signUpDto);

}
