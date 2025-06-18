package com.brownbox.warehouse.service;

import com.brownbox.warehouse.entity.StockItem;
import com.brownbox.warehouse.repository.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    @Autowired private StockItemRepository repo;

    public List<StockItem> processIn(List<String> barcodes, String itemType, String zone, List<Integer> shelves) {
        List<StockItem> result = new ArrayList<>();
        for (int i = 0; i < barcodes.size(); i++) {
            String barcode = barcodes.get(i);
            StockItem item = new StockItem();
            item.setBarcode(barcode);
            item.setItemType(itemType);
            item.setZone(zone);
            item.setShelf(shelves.get(i));
            item.setStatus("I");
            item.setCreatedAt(LocalDateTime.now());
            item.setUpdatedAt(LocalDateTime.now());
            result.add(repo.save(item));
        }
        return result;
    }

    public void processOut(List<String> barcodes) {
        for (String barcode : barcodes) {
            repo.findByBarcode(barcode).ifPresent(item -> {
                item.setStatus("P");
                item.setUpdatedAt(LocalDateTime.now());
                repo.save(item);
            });
        }
    }

    public void confirmSend(List<String> barcodes) {
        for (String barcode : barcodes) {
            repo.findByBarcode(barcode).ifPresent(item -> {
                item.setStatus("Y");
                item.setUpdatedAt(LocalDateTime.now());
                repo.save(item);
            });
        }
    }

    public List<StockItem> getRemainingStock() {
        return repo.findByStatus("I");
    }

    public List<StockItem> getOutStock() {
        return repo.findByStatus("P");
    }
}
