package com.javatask.SupplierService.dao;

import com.javatask.SupplierService.model.Supplier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
    @Query("SELECT * FROM supplier WHERE location=" +
            "location, nature_of_business= natureOfBusiness, manufacturing_process= manufacturingProcess")
    Page<Supplier> getSuppliers(@RequestParam String location, @RequestParam String natureOfBusiness, @RequestParam String manufacturingProcess, Pageable pageable);

    Optional<Supplier> findByUserName(String username);
}
