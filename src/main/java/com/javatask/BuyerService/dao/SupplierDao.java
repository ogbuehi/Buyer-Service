package com.javatask.BuyerService.dao;

import com.javatask.BuyerService.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    @Query("SELECT * FROM supplier WHERE location=" +
            "location, nature_of_business= natureOfBusiness, manufacturing_process= manufacturingProcess")
    Page<Supplier> getSuppliers(String location, String natureOfBusiness, String manufacturingProcess, Pageable pageable);

    Optional<Supplier> findByUserName(String username);
}
