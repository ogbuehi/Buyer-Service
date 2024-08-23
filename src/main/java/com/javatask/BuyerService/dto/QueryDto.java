package com.javatask.BuyerService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class QueryDto {
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcess;
}
