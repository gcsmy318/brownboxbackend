package com.brownbox.warehouse.controller;

import com.brownbox.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/stock")
public class StockController {
    @Autowired private StockService stockService;

    @PostMapping("/in")
    public void processIn(@RequestBody Map<String, Object> body) {
        System.out.println("in");
        List<String> barcodes = (List<String>) body.get("barcodes");
        String type = (String) body.get("type");
        String zone = (String) body.get("zone");
        List<Integer> shelves = (List<Integer>) body.get("shelves");
        stockService.processIn(barcodes, type, zone, shelves);
    }

    @PostMapping("/out")
    public void processOut(@RequestBody Map<String, Object> body) {
        System.out.println("out");
        List<String> barcodes = (List<String>) body.get("barcodes");
        System.out.println("barcodes"+barcodes.toString());
        stockService.processOut(barcodes);
    }

    @PostMapping("/send")
    public void confirmSend(@RequestBody Map<String, Object> body) {
        System.out.println("send");
        List<String> barcodes = (List<String>) body.get("barcodes");
        System.out.println("barcodes"+barcodes.toString());
        stockService.confirmSend(barcodes);
    }


}
