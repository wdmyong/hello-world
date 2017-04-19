package com.wdm.example.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class DataSourceComponent {

    @Resource
    MasterDataSourceConfig masterDataSourceConfig;

    @Resource
    FirstDataSourceConfig firstDataSourceConfig;

    @Resource
    SecondDataSourceConfig secondDataSourceConfig;

    /*
     * 一开始以为springboot的自动配置还是会生效，直接加了@Resource DataSource dataSource；
     * 显示是不work的，会报create bean 错误
     */
    public DataSource masterDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(masterDataSourceConfig.getUrl());
        dataSource.setUsername(masterDataSourceConfig.getUsername());
        dataSource.setPassword(masterDataSourceConfig.getPassword());
        dataSource.setDriverClassName(masterDataSourceConfig.getDriverClassName());
        return dataSource;
    }

    /*
     * 一开始在这里加了@Bean的注解，当然secondDataSource()也加了
     * 会导致springboot识别的时候，发现有多个
     * 所以，其实都不要加@Bean，最终有效的的DataSource就只需要一个multiDataSource即可
     */
    public DataSource firstDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(firstDataSourceConfig.getUrl());
        dataSource.setUsername(firstDataSourceConfig.getUsername());
        dataSource.setPassword(firstDataSourceConfig.getPassword());
        dataSource.setDriverClassName(firstDataSourceConfig.getDriverClassName());
        return dataSource;
    }

    public DataSource secondDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(secondDataSourceConfig.getUrl());
        dataSource.setUsername(secondDataSourceConfig.getUsername());
        dataSource.setPassword(secondDataSourceConfig.getPassword());
        dataSource.setDriverClassName(secondDataSourceConfig.getDriverClassName());
        return dataSource;
    }

    @Bean(name = "multiDataSource")
    public MultiRouteDataSource exampleRouteDataSource() {
        MultiRouteDataSource multiDataSource = new MultiRouteDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSource());
        targetDataSources.put("first", firstDataSource());
        targetDataSources.put("second", secondDataSource());
        multiDataSource.setTargetDataSources(targetDataSources);
        multiDataSource.setDefaultTargetDataSource(masterDataSource());
        return multiDataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(exampleRouteDataSource());
        return manager;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(exampleRouteDataSource());
        return sessionFactoryBean;
    }
}
