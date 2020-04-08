package com.evan.confige;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author evanYang
 * @version 1.0
 * @date 2020/04/08 20:39
 */
@Configuration
public class DataBase1Config {
    @Bean(name="database1")
    @ConfigurationProperties(prefix = "spring.datasource.database1")
    public DataSource dateSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="database2")
    @ConfigurationProperties(prefix = "spring.datasource.database2")
    public DataSource dateSourceTwo(){
        return DataSourceBuilder.create().build();
    }

}
