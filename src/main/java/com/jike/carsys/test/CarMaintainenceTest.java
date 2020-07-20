package com.jike.carsys.test;

import com.jike.carsys.bean.CarMaintenance;
import com.jike.carsys.dao.ICarMaintenanceDao;
import com.jike.carsys.util.DataSourceSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jike.carsys.util.DataSourceSqlSessionFactory.DataSourceEnvironment.oracle;
import static org.junit.Assert.assertEquals;

public class CarMaintainenceTest {
    @Test
    public void count() {
        //创建SqlSession对象
        SqlSession sqlSession = null;
        int count = 0;
        try {
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( oracle );
            sqlSession = sqlSessionFactory.openSession();
            count = sqlSession.getMapper( ICarMaintenanceDao.class ).queryCount();
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( oracle );
            sqlSession = sqlSessionFactory.openSession();
            count1 = sqlSession.getMapper( ICarMaintenanceDao.class ).queryCount();
            System.out.println( "count1=" + count1 );
           // CarMaintenance cam1 = new CarMaintenance( 1, "2020-07-20 09:00:00", "N", "张三", "12345678888", "666666" );
             CarMaintenance cam1=new CarMaintenance(2,"2020-07-20 10:00:00" ,"N","李四","12345676666","888888");
            List<CarMaintenance> cam = new ArrayList<CarMaintenance>();
            cam.add( cam1 );
            sqlSession.getMapper( ICarMaintenanceDao.class ).insert( cam );
            sqlSession.commit();
            count2 = sqlSession.getMapper( ICarMaintenanceDao.class ).queryCount();
            System.out.println( "count2=" + count2 );
            assertEquals( count1 + 1, count2 );

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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( oracle );
            sqlSession = sqlSessionFactory.openSession();
            //删除 非VIP的预约
            CarMaintenance cam = new CarMaintenance( "N" );
            sqlSession.getMapper( ICarMaintenanceDao.class ).delete( cam );
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( oracle );
            sqlSession = sqlSessionFactory.openSession();
            // 将姓名为张三，手机号为12345678888的客户设为vip
            CarMaintenance query = new CarMaintenance( "张三", "12345678888" );
            CarMaintenance update = new CarMaintenance();
            update.setIsVip( "Y" );
            sqlSession.getMapper( ICarMaintenanceDao.class ).update( query, update );
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
            SqlSessionFactory sqlSessionFactory = DataSourceSqlSessionFactory.getSqlSessionFactory( oracle );
            sqlSession = sqlSessionFactory.openSession();
            //查询所有
            List<CarMaintenance> cam = sqlSession.getMapper( ICarMaintenanceDao.class ).query( null );
            System.out.println( cam );
            //查询所有VIP用户
            CarMaintenance cam1 = new CarMaintenance( "Y" );
            sqlSession.getMapper( ICarMaintenanceDao.class ).query( cam1 );
            sqlSession.commit();
            System.out.println( cam1 );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }


    }
}
