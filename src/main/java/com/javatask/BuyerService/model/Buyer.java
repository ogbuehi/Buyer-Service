package com.javatask.BuyerService.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "buyer")
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Integer id;
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "SUPPLIER MAPPING", joinColumns = @JoinColumn(name = "buyer_id"), 
        inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> supplier;
}
