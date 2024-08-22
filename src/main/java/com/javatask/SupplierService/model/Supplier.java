package com.javatask.SupplierService.model;

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
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer id;
    @NotNull
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "password")
    @NotNull
    private String password;
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
}
