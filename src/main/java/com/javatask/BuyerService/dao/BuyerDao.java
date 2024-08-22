package com.javatask.BuyerService.dao;

import com.javatask.BuyerService.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerDao extends JpaRepository<Buyer, Integer> {
    Optional<Buyer> findByUserName(String username);
}
