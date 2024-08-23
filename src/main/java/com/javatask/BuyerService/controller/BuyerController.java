package com.javatask.BuyerService.controller;

import com.javatask.BuyerService.dto.BuyerSignUpDto;
import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import com.javatask.BuyerService.service.BuyerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buyer")
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;

    // To add a buyer to the database
    // localhost:8080/api/buyer/add_buyer
    // then add body in the request containing username, password and email to add buyer.
    @Secured("ROLE_USER")
    @PostMapping("/add_buyer")
    public ResponseEntity<String> addBuyer(@RequestBody BuyerSignUpDto buyerSignUpDto){
        return buyerService.addBuyer(buyerSignUpDto);
    }
    // To get the buyer's own criteria of manufacturers from the database
    // localhost:8080/api/buyer/get_suppliers?pageNum=1&pageSize=5
    // then add a body in the request containing the location, nature of business and manufacturing process to get result.
    @GetMapping("/get_suppliers")
    public ResponseEntity<SupplierResponse> getSpecificSuppliers
    (@RequestParam(value = "pageNum", defaultValue="0") int pageNum,
     @RequestParam(value = "pageSize", defaultValue="10") int pageSize,
     @RequestBody @Valid QueryDto queryDto){
        return buyerService.getSpecificSuppliers(pageNum, pageSize, queryDto);
    }
}
