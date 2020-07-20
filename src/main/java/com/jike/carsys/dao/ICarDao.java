package com.jike.carsys.dao;

import com.jike.carsys.bean.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ICarDao {
    /**
     * 插入
     *
     * @param cars
     * @return
     */
    void insert(List<Car> cars);

    /**
     * 删除
     *
     * @param car 参数为null时，删除所有，谨慎使用；
     *            参数不为null 按照car对象中不为null的字段 进行查询，删除满足条件的，若有多个字段不问null时，多个字段之间使用and
     * @return
     */
    void delete(@Param("c") Car car);

    /**
     * 更新
     *
     * @param query 参数为null，更新所有数据库中所有记录
     *              参数不为null 按照对象中不为null的字段 进行查询，更新满足条件的，若有多个字段不问null时，多个字段之间使用and
     * @param up
     * @return
     */
    void update(@Param("q") Car query, @Param("u") Car up);

    /**
     * 查询
     *
     * @param car 参数为null时，查询所有的内容
     *            参数不为null时，按照对象中不为null的字段 进行查询，若有多个字段不问null时，多个字段之间使用and
     * @return
     */
    List<Car> query(@Param("c") Car car);

    int queryCount();

}


