package com.ass1.inv.Controller;

import com.ass1.inv.exception.BadRequestException;
import com.ass1.inv.exception.ResourceNotFoundException;
import com.ass1.inv.model.Warehouse;
import com.ass1.inv.service.WarehouseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final Logger log = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable(name = "id") long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@Valid @RequestBody Warehouse warehouse) {
        if (warehouse.getWarehouseId() != null) {
            throw new BadRequestException("Warehouse", "id");
        }
        if (warehouse.getName() == null) {
            throw new BadRequestException("Warehouse", "name");
        }
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@Valid @RequestBody Warehouse warehouse,
                                                     @PathVariable(name = "id") long id) {
        warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));

        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouse);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable(name = "id") long id) {
        warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));

        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
