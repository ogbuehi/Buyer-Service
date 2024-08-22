package com.javatask.SupplierService.service;

import com.javatask.SupplierService.dao.SupplierDao;
import com.javatask.SupplierService.dto.QueryDto;
import com.javatask.SupplierService.dto.SignUpDto;
import com.javatask.SupplierService.dto.SupplierResponse;
import com.javatask.SupplierService.exception.SupplierException;
import com.javatask.SupplierService.model.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierDao supplierDao;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public ResponseEntity<String> saveSupplier(SignUpDto signUpDto) {
        try {
            Supplier supplier = new Supplier();
            supplier.setCompanyName(signUpDto.getCompanyName());
            supplier.setPassword(encoder.encode(signUpDto.getPassword()));
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

    @Override
    public ResponseEntity<SupplierResponse>
    getSpecificSuppliers(int pageNum, int pageSize,QueryDto queryDto) {
        try {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            Page<Supplier> supplierDB = supplierDao.getSuppliers(queryDto.getLocation(),
                    queryDto.getNatureOfBusiness(), queryDto.getManufacturingProcess(), pageable);
            List<Supplier> suppliers = supplierDB.getContent();

            SupplierResponse response = new SupplierResponse();
            response.setContent(suppliers);
            response.setPageNum(pageNum);
            response.setPageSize(pageSize);
            response.setTotalElements(response.getTotalElements());
            response.setTotalPages(response.getTotalPages());
            response.setLast(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (SupplierException e){
            throw new SupplierException("ERROR OCCURRED WHILE GETTING SUPPLIERS");
        }

    }
}
