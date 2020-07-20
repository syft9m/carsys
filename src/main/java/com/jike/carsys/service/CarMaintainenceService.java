package com.jike.carsys.service;

import com.jike.carsys.bean.CarMaintenance;

import com.jike.carsys.dao.ICarMaintenanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carMaintenanceService")
public class CarMaintainenceService {
    @Autowired
    private ICarMaintenanceDao carMaintenance;

    public void insert(List<CarMaintenance> cam) {
        carMaintenance.insert( cam );
    }

    public List<CarMaintenance> query(CarMaintenance cam) {
        return carMaintenance.query( cam );
    }

    public void update(CarMaintenance query, CarMaintenance up) {
        carMaintenance.update( query, up );
    }

    public void delete(CarMaintenance cam) {
        carMaintenance.delete( cam );
    }
}
