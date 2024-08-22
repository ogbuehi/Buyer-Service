package com.javatask.SupplierService.dto;

import com.javatask.SupplierService.model.Supplier;
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
