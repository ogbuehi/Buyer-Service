package com.javatask.BuyerService.service;

import com.javatask.BuyerService.dao.BuyerDao;
import com.javatask.BuyerService.dao.SupplierDao;
import com.javatask.BuyerService.dto.BuyerSignUpDto;
import com.javatask.BuyerService.dto.QueryDto;
import com.javatask.BuyerService.dto.SupplierResponse;
import com.javatask.BuyerService.exception.SupplierException;
import com.javatask.BuyerService.model.Buyer;
import com.javatask.BuyerService.model.Supplier;
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
public class BuyerServiceImpl implements BuyerService {
    private final BuyerDao buyerDao;
    private final SupplierDao supplierDao;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public ResponseEntity<String> addBuyer(BuyerSignUpDto buyerSignUpDto) {
        Buyer buyer = new Buyer();
        buyer.setUsername(buyerSignUpDto.getUsername());
        buyer.setPassword(encoder.encode(buyerSignUpDto.getPassword()));
        buyer.setEmail(buyerSignUpDto.getEmail());
        buyerDao.save(buyer);
        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SupplierResponse> getSpecificSuppliers(int pageNum, int pageSize, QueryDto queryDto) {
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
