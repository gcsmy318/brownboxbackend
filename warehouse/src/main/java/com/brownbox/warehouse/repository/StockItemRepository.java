package com.brownbox.warehouse.repository;

import com.brownbox.warehouse.entity.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    List<StockItem> findByStatus(String status);
    List<StockItem> findByZoneAndShelf(String zone, int shelf);
    Optional<StockItem> findByBarcode(String barcode);
}
