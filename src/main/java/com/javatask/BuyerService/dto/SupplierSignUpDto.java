package com.javatask.BuyerService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SupplierSignUpDto {
    @NotNull
    private String companyName;
    @NotNull
    private String website;
    @NotNull
    private String location;
    @NotNull
    private String natureOfBusiness;
    @NotNull
    private String manufacturingProcess;
}
