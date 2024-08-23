package com.javatask.BuyerService.controller;

import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import com.javatask.BuyerService.dto.SupplierSignUpDto;
import com.javatask.BuyerService.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    // To add a supplier to the database
    // localhost:8080/api/supplier/add_supplier
    // then add to method body all the fields required, to add supplier.
    @PostMapping("/add_supplier")
    public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierSignUpDto signUpDto){
        return supplierService.saveSupplier(signUpDto);
    }


}
