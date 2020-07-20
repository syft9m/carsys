package com.jike.carsys.test;

import com.jike.carsys.bean.Car;

import com.jike.carsys.dao.ICarDao;

import com.jike.carsys.util.DataSourceSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.jike.carsys.util.DataSourceSqlSessionFactory.DataSourceEnvironment.mysql;
import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
@SpringBootTest
@Transactional(transactionManager = "mysqlManager")
public class CarServiceTest {

    @Test
    public void count() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        int count = 0;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( mysql );
            sqlSession = sqlSessionFactory.openSession();
            count = sqlSession.getMapper( ICarDao.class ).queryCount();
            System.out.println( count );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }
    }

    @Test
    public void insert() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        int count1 = 0;
        int count2 = 0;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( mysql );
            sqlSession = sqlSessionFactory.openSession();
            count1 = sqlSession.getMapper( ICarDao.class ).queryCount();
            System.out.println( "count1=" + count1 );
            Car car1 = new Car( 9, "雪佛兰", "SUV", 120005.0f );
            Car car2 = new Car( 10, "奥迪", "轿车", 500000.0f );
            List<Car> cars = new ArrayList<Car>();
            cars.add( car1 );
            cars.add( car2 );
            sqlSession.getMapper( ICarDao.class ).insert( cars );
            sqlSession.commit();
            count2 = sqlSession.getMapper( ICarDao.class ).queryCount();
            assertEquals( count1 + 2, count2 );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }

    }

    @Test
    public void delete() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        int count1 = 0;
        int count2 = 0;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( mysql );
            sqlSession = sqlSessionFactory.openSession();
            count1 = sqlSession.getMapper( ICarDao.class ).queryCount();
            System.out.println( "count1=" + count1 );
            //删除宝马，SUV,价格低于500000
            Car car1 = new Car( 8, "宝马", "SUV", 500000.0f );
            sqlSession.getMapper( ICarDao.class ).delete( car1 );
            sqlSession.commit();
            count2 = sqlSession.getMapper( ICarDao.class ).queryCount();
            System.out.println( "count2=" + count2 );
            assertEquals( count1 - 1, count2 );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }

    }

    @Test
    public void update() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( mysql );
            sqlSession = sqlSessionFactory.openSession();
            // 更新SUV 的价格
            Car query = new Car( 8, "SUV", 380000.f );
            Car update = new Car( 600000.f );
            sqlSession.getMapper( ICarDao.class ).update( query, update );
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }

    }

    @Test
    public void query() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( mysql );
            sqlSession = sqlSessionFactory.openSession();
            //查询所有
            List<Car> cars = sqlSession.getMapper( ICarDao.class ).query( null );
            System.out.println( cars );
            //查询所有奔驰车
            List<Car> cars1 = sqlSession.getMapper( ICarDao.class ).query( new Car( "奔驰" ) );
            System.out.println( cars1 );
            //查询奔驰，SUV
            List<Car> cars2 = sqlSession.getMapper( ICarDao.class ).query( new Car( "奔驰", "SUV" ) );
            System.out.println( cars2 );
            //查询轿车，价格小于200000.0
            List<Car> cars3 = sqlSession.getMapper( ICarDao.class ).query( new Car( "轿车", "50000.0f" ) );
            System.out.println( cars3 );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }

    }


}
