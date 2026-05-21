/*package com.cqrs.CqrsPractical.config;

import com.cqrs.CqrsPractical.enums.DBType;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    //Ha .yml mdhun configuration read karun/gheun connection object create karel.
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary//default bean
    public DataSource dataSource() {// dynamic datasource routing  provide

        Map<Object, Object> map = new HashMap<>();
        map.put(DBType.WRITE, writeDataSource());
        map.put(DBType.READ, readDataSource());

        RountingDataSource routing = new RountingDataSource(); //class which run time pr datasource decide krega
        routing.setTargetDataSources(map);// apan ithe donhi db spring la dile mhnje register kele.
        routing.setDefaultTargetDataSource(writeDataSource());// ani jar ek pan db set jhala nasel tr write db la default mhnun use kr.


        routing.afterPropertiesSet(); // this is the spring lifecycle method which ensures all property sets properly.

        return routing;

    }
}*/
