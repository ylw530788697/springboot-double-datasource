package com.evan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author evanYang
 * @version 1.0
 * @date 2020/04/08 20:50
 */
@SpringBootApplication
@MapperScan("com.evan.mapper.*")
public class DataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class,args);
    }
}
