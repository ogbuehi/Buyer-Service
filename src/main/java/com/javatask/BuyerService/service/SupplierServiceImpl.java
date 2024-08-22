package com.javatask.BuyerService.service;

import com.javatask.BuyerService.dao.SupplierDao;
import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import com.javatask.BuyerService.dto.SupplierSignUpDto;
import com.javatask.BuyerService.exception.SupplierException;
import com.javatask.BuyerService.model.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;

    @Override
    public ResponseEntity<String> saveSupplier(SupplierSignUpDto signUpDto) {
        try {
            Supplier supplier = new Supplier();
            supplier.setCompanyName(signUpDto.getCompanyName());
            supplier.setWebsite(signUpDto.getWebsite());
            supplier.setLocation(signUpDto.getLocation());
            supplier.setNatureOfBusiness(signUpDto.getNatureOfBusiness());
            supplier.setManufacturingProcess(signUpDto.getManufacturingProcess());
            supplierDao.save(supplier);
        }catch (SupplierException e){
            throw new SupplierException("AN ERROR OCCURRED WHILE ADDING SUPPLIER");
        }
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }
}
