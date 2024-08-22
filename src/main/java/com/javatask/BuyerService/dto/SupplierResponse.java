package com.javatask.BuyerService.dto;

import com.javatask.BuyerService.model.Supplier;
import lombok.Data;

import java.util.List;
@Data
public class SupplierResponse {
    private List<Supplier> content;
    private int pageNum;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
