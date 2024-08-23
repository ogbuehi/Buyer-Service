package com.javatask.BuyerService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class QueryDto {
    @NotNull
    private String location;
    @NotNull
    private String natureOfBusiness;
    @NotNull
    private String manufacturingProcess;
}
