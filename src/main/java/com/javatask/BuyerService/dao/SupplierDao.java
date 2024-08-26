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
    @Query("SELECT * FROM supplier WHERE location= ?" +
            ", nature_of_business= ? AND manufacturing_process= ?", nativeQuery = true)
    Page<Supplier> getSuppliers(@Param("location") String location, @Param("natureOfBusiness") String natureOfBusiness,
                                @Param("manufacturingProcess") String manufacturingProcess, Pageable pageable);

    Optional<Supplier> findByUserName(String username);
}
