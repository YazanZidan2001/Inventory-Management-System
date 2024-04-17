package com.ass1.inv.service;

import com.ass1.inv.model.Warehouse;
import com.ass1.inv.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }


    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        if (warehouseRepository.existsById(id)) {
            warehouse.setWarehouseId(id);
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

//    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
//        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
//        if (optionalWarehouse.isPresent()) {
//            Warehouse existingWarehouse = optionalWarehouse.get();
//            existingWarehouse.setName(warehouse.getName());
//            existingWarehouse.setLocation(warehouse.getLocation());
//            existingWarehouse.setCapacity(warehouse.getCapacity());
//            return warehouseRepository.save(existingWarehouse);
//        } else {
//            return null;
//        }
//    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
