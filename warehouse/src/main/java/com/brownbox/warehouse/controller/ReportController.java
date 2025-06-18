package com.brownbox.warehouse.controller;

import com.brownbox.warehouse.repository.StockItemRepository;
import com.brownbox.warehouse.service.StockService;
import com.brownbox.warehouse.entity.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/report")
public class ReportController {
    @Autowired private StockService stockService;

    @GetMapping("/remain")
    public List<StockItem> getRemaining() {
        return stockService.getRemainingStock();
    }

    @GetMapping("/out")
    public List<StockItem> getOutStock() {
        return stockService.getOutStock();
    }

    @Autowired
    private StockItemRepository stockItemRepository;

    @GetMapping("/all")
    public List<StockItem> getAllStockItems() {
        return stockItemRepository.findAll();
    }

    @Autowired
    private StockItemRepository repo;

    @GetMapping("/picked")
    public List<StockItem> getPickedItems() {
        return repo.findByStatus("P"); // แสดงรายการสถานะ 'P'
    }
}







