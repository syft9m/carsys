package com.jike.carsys.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DataSourceSqlSessionFactory {
    private static final String CONFIGURATION_PATH = "mybatis-3-config.xml";

    private static final Map<DataSourceEnvironment, SqlSessionFactory> SQLSESSIONFACTORYS
            = new HashMap<DataSourceEnvironment, SqlSessionFactory>();

    /**
     * 根据指定的DataSourceEnvironment获取对应的SqlSessionFactory
     *
     * @param environment 数据源environment
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(DataSourceEnvironment environment) {

        SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get( environment );
        if (ObjectUtils.isEmpty( sqlSessionFactory )) {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream( CONFIGURATION_PATH );
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream, environment.name() );


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly( inputStream );
            }

            SQLSESSIONFACTORYS.put( environment, sqlSessionFactory );
            return sqlSessionFactory;
        } else {
            return sqlSessionFactory;
        }


    }

    /**
     * 配置到Configuration.xml文件中的数据源的environment的枚举描述
     *
     * @author fx
     * @version 2020-7-29
     */
    public static enum DataSourceEnvironment {
        mysql,
        postgresql,
        oracle;
    }
}
