package com.javatask.SupplierService.controller;

import com.javatask.SupplierService.dto.QueryDto;
import com.javatask.SupplierService.dto.SignUpDto;
import com.javatask.SupplierService.dto.SupplierResponse;
import com.javatask.SupplierService.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    @PostMapping("/add")
    public ResponseEntity<String> addSupplier(@RequestBody @Valid SignUpDto signUpDto){
        return supplierService.saveSupplier(signUpDto);
    }
    @Secured("ROLE_USER")
    @GetMapping("/get")
    public ResponseEntity<SupplierResponse> getSpecificSuppliers
            (@RequestParam(value = "pageNum", defaultValue="0") int pageNum,
             @RequestParam(value = "pageSize", defaultValue="10") int pageSize,
             @RequestBody @Valid QueryDto queryDto){
        return supplierService.getSpecificSuppliers(pageNum, pageSize, queryDto);
    }
}
