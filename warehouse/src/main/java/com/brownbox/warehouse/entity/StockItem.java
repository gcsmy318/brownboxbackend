package com.brownbox.warehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class StockItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String barcode;
    private String productCode;
    private String poNumber;
    private String boxSize;    // S, M, L
    private String itemType;   // ลูกฟูก, Offset, วัตถุดิบ

    private int boxOrder;
    private int totalBox;

    private String zone;
    private int shelf;
    private String status;     // I, P, Y

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 🧠 อย่าลืมใส่ getter/setter หรือใช้ Lombok (@Data)
}
