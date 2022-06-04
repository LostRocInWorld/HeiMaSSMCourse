package com.dustin.anno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname SpringConfig
 * @Descrption TODO
 * @Date 2021/8/3上午 02:12
 * @Created By Dustin_Peng
 */
@Configuration
@ComponentScan(basePackages = {"com.dustin.anno.target"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
