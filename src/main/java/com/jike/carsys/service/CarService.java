package com.jike.carsys.service;

import com.jike.carsys.bean.Car;
import com.jike.carsys.dao.ICarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarService {
    @Autowired
    private ICarDao carDao;

    public void insert(List<Car> cars) {
        carDao.insert( cars );
    }

    public List<Car> query(Car car) {
        return carDao.query( car );
    }

    public void update(Car query, Car up) {
        carDao.update( query, up );
    }

    public void delete(Car car) {
        carDao.delete( car );
    }
}
