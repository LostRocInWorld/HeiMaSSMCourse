package com.dustin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname DataSourceConfiguration
 * @Descrption TODO
 * @Date 2021/7/21上午 03:45
 * @Created By Dustin_Peng
 */
@Configuration
@PropertySource(value = "classpath:jdbc2.properties",name = "jdbc2")
public class DataSourceConfiguration {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.name}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource") //Spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
