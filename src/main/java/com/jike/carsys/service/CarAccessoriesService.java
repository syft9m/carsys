package com.jike.carsys.service;

import com.jike.carsys.bean.CarAccessories;
import com.jike.carsys.dao.ICarAccessoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carAccessoriesService")
public class CarAccessoriesService {
    @Autowired
    private ICarAccessoriesDao casDao;

    public void insert(List<CarAccessories> cas) {
        casDao.insert( cas );
    }

    public List<CarAccessories> query(CarAccessories cas) {
        return casDao.query( cas );
    }

    public void update(CarAccessories query, CarAccessories up) {
        casDao.update( query, up );
    }

    public void delete(CarAccessories cas) {
        casDao.delete( cas );
    }
}
