package com.mantou.common.annotation.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * SpringCloudApplication组合注解
 * (住: 适用于SpringCloud框架)
 * @author mantou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan
@EnableFeignClients
public @interface SpringCloudPlusApplication {

    /**---------------------------@EnableFeignClients注解-------------------------------**/
    @AliasFor(
            annotation = EnableFeignClients.class,
            attribute = "basePackages"
    )
    String[] feignClientBasePackages() default {};

    @AliasFor(
            annotation = EnableFeignClients.class,
            attribute = "basePackageClasses"
    )
    Class<?>[] feignClientBasePackageClasses() default {};
    /**---------------------------@EnableFeignClients注解-------------------------------**/

    /**------------------------------@MapperScan注解-----------------------------------**/
    @AliasFor(
            annotation = MapperScan.class,
            attribute = "basePackages"
    )
    String[] mapperScanBasePackages() default {};

    @AliasFor(
            annotation = MapperScan.class,
            attribute = "basePackageClasses"
    )
    Class<?>[] mapperScanBasePackageClasses() default {};
    /**------------------------------@MapperScan注解-----------------------------------**/

    /**-----------------------@EnableAutoConfiguration注解----------------------------**/
    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    Class<?>[] exclude() default {};

    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    String[] excludeName() default {};

    /**-----------------------@EnableAutoConfiguration注解----------------------------**/

    /**---------------------------@ComponentScan注解----------------------------------**/
    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackages"
    )
    String[] scanBasePackages() default {};

    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};
    /**---------------------------@ComponentScan注解----------------------------------**/

}
