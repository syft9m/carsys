package com.jike.carsys.test;


import com.jike.carsys.bean.CarAccessories;
import com.jike.carsys.dao.ICarAccessoriesDao;
import com.jike.carsys.util.DataSourceSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.jike.carsys.util.DataSourceSqlSessionFactory.DataSourceEnvironment.postgresql;
import static org.junit.Assert.assertEquals;

@Transactional(transactionManager = "postgresqlManager")
public class CarAccessoriesServiceTest {

    @Test
    public void count() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        int count = 0;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( postgresql );
            sqlSession = sqlSessionFactory.openSession();
            count = sqlSession.getMapper( ICarAccessoriesDao.class ).queryCount();
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( postgresql );
            sqlSession = sqlSessionFactory.openSession();
            count1 = sqlSession.getMapper( ICarAccessoriesDao.class ).queryCount();
            CarAccessories cas1 = new CarAccessories( 21, "雪佛兰", "发动机", true, 5000.0f );
            CarAccessories cas2 = new CarAccessories( 22, "雪佛兰", "轮胎", true, 2000.0f );
            List<CarAccessories> cas = new ArrayList<CarAccessories>();
            cas.add( cas1 );
            cas.add( cas2 );
            sqlSession.getMapper( ICarAccessoriesDao.class ).insert( cas );
            sqlSession.commit();
            count2 = sqlSession.getMapper( ICarAccessoriesDao.class ).queryCount();
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
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( postgresql );
            sqlSession = sqlSessionFactory.openSession();
            //删除 轮胎无货
            CarAccessories cas = new CarAccessories( "轮胎", false );
            sqlSession.getMapper( ICarAccessoriesDao.class ).delete( cas );
            sqlSession.commit();
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( postgresql );
            sqlSession = sqlSessionFactory.openSession();
            // 将价格小于等于1000的轮胎修改为无货
            CarAccessories query = new CarAccessories( "轮胎", 10000.0f );
            CarAccessories update = new CarAccessories();
            update.setAvailability( false );
            sqlSession.getMapper( ICarAccessoriesDao.class ).update( query, update );
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( postgresql );
            sqlSession = sqlSessionFactory.openSession();
            //查询所有
            List<CarAccessories> cas = sqlSession.getMapper( ICarAccessoriesDao.class ).query( null );
            System.out.println( cas );
            //查询轮胎，有货，价格低于5000

            CarAccessories cas1 = new CarAccessories( "轮胎", true, 5000.f );
            sqlSession.getMapper( ICarAccessoriesDao.class ).query( cas1 );
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }


    }


}
