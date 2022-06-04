package com.dustin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @Classname SpringConfiguration
 * @Descrption TODO
 * @Date 2021/7/21上午 03:34
 * @Created By Dustin_Peng
 */
@Configuration  //标志该类是Spring核心配置类
@ComponentScan(basePackages = {"com.dustin.dao","com.dustin.service"})  //配置组件扫描
@Import(DataSourceConfiguration.class)    //引入其他Spring配置文件
public class SpringConfiguration {

}
