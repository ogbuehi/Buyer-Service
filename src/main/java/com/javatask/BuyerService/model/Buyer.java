package com.javatask.BuyerService.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @ManyToMany
    private Supplier supplier;
}
