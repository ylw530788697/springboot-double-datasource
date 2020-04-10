package com.evan.constant;

/**
 * @author evanYang
 * @version 1.0
 * @date 2020/04/08 20:39
 */
public class DBConstants {

    /**
     * 数据源配置
     */
    public static final String FIRST_DATA_SOURCE = "firstDataSource";
    public static final String SECOND_DATA_SOURCE = "secondDataSource";

    /**
     * sqlSessionFactory
     */
    public static final String FIRST_SQL_SESSION_FACTORY = "firstSqlSessionFactory";
    public static final String SECOND_SQL_SESSION_FACTORY = "secondSqlSessionFactory";

    /**
     * mapper接口
     */
    public static final String FIRST_MAPPER = "com.evan.mapper.first";
    public static final String SECOND_MAPPER = "com.evan.mapper.second";
    /**
     * mapper.xml目录
     */
    public static final String FIRST_MAPPER_XML = "classpath:first-mapper/*.xml";
    public static final String SECOND_MAPPER_XML = "classpath:second-mapper/*.xml";
}
