package com.javatask.BuyerService.service;

import com.javatask.BuyerService.dto.BuyerSignUpDto;
import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import org.springframework.http.ResponseEntity;

public interface BuyerService {
    ResponseEntity<String> addBuyer(BuyerSignUpDto buyerSignUpDto);
    ResponseEntity<SupplierResponse> getSpecificSuppliers(int pageNum, int pageSize, QueryDto queryDto);
}
