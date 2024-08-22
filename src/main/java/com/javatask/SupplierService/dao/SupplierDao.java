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
    @Query(value = "SELECT * FROM supplier WHERE location=" +
            ":location, nature_of_business= :natureOfBusiness AND manufacturing_process= :manufacturingProcess", nativeQuery = true)
    Page<Supplier> getSuppliers(@Param("location") String location, @Param("natureOfbusiness") String natureOfBusiness,
                                @Param("manufacturingProcess") String manufacturingProcess, Pageable pageable);

    Optional<Supplier> findByUserName(String username);
}
