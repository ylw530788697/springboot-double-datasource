package com.evan.confige;

import com.evan.util.SqlSessionFactoryUtil;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author evanYang
 * @version 1.0
 * @date 2020/04/08 20:39
 */
@Configuration
@MapperScan(basePackages = "com.evan.mapper.database1",sqlSessionFactoryRef = "data1SqlSessionFactory")
public class DataBase1Config {

    //mapper文件目录
    private static final String MAPPER_LOCATIONS = "classpath:mapper/database1/*.xml";
    @Bean(name="data1Source")
    @ConfigurationProperties(prefix = "spring.datasource.database1")
    public DataSource dateSource(){
        return DataSourceBuilder.create().build();
    }

    ///**
    // * 返回data1数据库的数据源
    // * @return
    // */
    //@Bean(name="data1Source")
    //@Primary//主数据源
    //@ConfigurationProperties(prefix = "spring.datasource.data1")
    //public DataSource dataSource(){
    //    return DataSourceBuilder.create().build();
    //}

    /**
     * 返回data1数据库的会话工厂
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean(name = "data1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data1Source") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }

    //@Bean(name = "druidSqlSessionFactory")
    //@Primary
    //public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) {
    //    return SqlSessionFactoryUtil.createSqlSessionFactory(masterDataSource,TYPE_ALIASES_PACKAGE,
    //            TYPE_HANDLERS_PACKAGE,MAPPER_LOCATIONS,mybatisConfig,new Interceptor[] {pageInterceptor});
    //}
    /**
     * 返回data1数据库的会话模板
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "data1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
        return  new SqlSessionTemplate(sessionFactory);
    }

    /**
     * 返回data1数据库的事务
     * @param ds
     * @return
     */
    @Bean(name = "data1TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("data1Source") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
