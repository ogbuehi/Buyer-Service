package com.javatask.SupplierService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpDto {
    @NotNull
    private String companyName;
    @NotNull
    private String password;
    @NotNull
    private String website;
    @NotNull
    private String location;
    @NotNull
    private String natureOfBusiness;
    @NotNull
    private String manufacturingProcess;
}
