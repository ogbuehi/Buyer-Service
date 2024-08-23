package com.javatask.BuyerService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "supplier")
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer id;
    @NotNull
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "website")
    @NotNull
    private String website;
    @NotNull
    @Column(name = "location")
    private String location;
    @NotNull
    @Column(name = "nature_of_business")
    private String natureOfBusiness;
    @NotNull
    @Column(name = "manufacturing_process")
    private String manufacturingProcess;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "SUPPLIER MAPPING", joinColumns = @JoinColumn(name = "supplier_id"), 
        inverseJoinColumns = @JoinColumn(name = "buyer_id"))
    private Set<Buyer> buyers;
}
