package com.evan;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author evanYang
 * @version 1.0
 * @date 09/25/2019 12:17
 */
public class CodeGenerator {

    public static void main(String[] args) {

        String packageName = "com.evan";   // 生成的包名
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        String dir = "D:\\IdeaProjects\\springboot-double-datasource\\src\\main\\java";
        generateByTables(serviceNameStartWithI,
                packageName,
                dir, ""
        );
    }
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String dir, String... tableNames ) {
        GlobalConfig globalConfig = new GlobalConfig();
        //mysql
        //String dbUrl = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        //DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //dataSourceConfig.setDbType(DbType.MYSQL)
        //        .setUrl(dbUrl)
        //        .setUsername("root")
        //        .setPassword("root")
        //        .setDriverName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/database2?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
         //strategyConfig.setInclude("okya_version_manage");//"表名，多个英文逗号分割".split(",")
        strategyConfig
                .setCapitalMode(false)   // 全局大写命名
                .setEntityLombokModel(true)   // Lomnok
                // .setDbColumnUnderline(true)   // 表名 字段名 是否使用下滑线命名
                .setTablePrefix("okya_") // 去除表前缀
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel) //// underline_to_camel数据库表映射到实体的命名策略
                //设置父类路径
                .setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper")
                .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")
                .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        //.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");


        // 全局配置
        globalConfig.setActiveRecord(true)   //是否支持AR模式
                .setAuthor("EvanYang")   // 设置作者
                .setOutputDir(dir)   // 设置生成的目标路径（绝对路径）
                .setIdType(IdType.UUID) //主键策略
                .setBaseColumnList(true)  // 设置sql片段
                .setBaseResultMap(true)  // resultMap
                .setEnableCache(false)   // 不开缓存
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setEntityName("%sModel")
                .setOpen(false) //生成之后 默认打开文件夹
                .setSwagger2(true)
                .setFileOverride(true);  // 每一次生成需要覆盖
        if (!serviceNameStartWithI) {
            globalConfig.setServiceName("%sService");
            globalConfig.setServiceImplName("%sServiceImpl");
        }
        //代码生成器
        new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("model")
                ).execute();
    }

    private void generateByTables(String packageName, String dir,String... tableNames) {
        generateByTables(true, packageName, dir, tableNames);
    }

}
