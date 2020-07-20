package com.jike.carsys.dao;

import com.jike.carsys.bean.CarMaintenance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICarMaintenanceDao {
    /**
     * 插入
     *
     * @param cam
     * @return
     */
    void insert(List<CarMaintenance> cam);

    /**
     * 删除
     *
     * @param cam 参数为null时，删除所有，谨慎使用；
     *            参数不为null 按照car对象中不为null的字段 进行查询，删除满足条件的，若有多个字段不问null时，多个字段之间使用and
     * @return
     */
    void delete(@Param("c") CarMaintenance cam);

    /**
     * 更新
     *
     * @param query 参数为null，更新所有数据库中所有记录
     *              参数不为null 按照对象中不为null的字段 进行查询，更新满足条件的，若有多个字段不问null时，多个字段之间使用and
     * @param up
     * @return
     */
    void update(@Param("q") CarMaintenance query, @Param("u") CarMaintenance up);

    /**
     * 查询
     *
     * @param cam 参数为null时，查询所有的内容
     *            参数不为null时，按照对象中不为null的字段 进行查询，若有多个字段不问null时，多个字段之间使用and
     * @return
     */
    List<CarMaintenance> query(@Param("c") CarMaintenance cam);

    int queryCount();
}
