package com.mantou.common.annotation.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * SpringBootApplication组合注解
 * (注: 用于SpringBoot框架)
 * @author mantou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@MapperScan
public @interface SpringBootPlusApplication {

    @AliasFor(
            annotation = SpringBootApplication.class
    )
    Class<?>[] exclude() default {};

    @AliasFor(
            annotation = SpringBootApplication.class
    )
    String[] excludeName() default {};

    @AliasFor(
            annotation = SpringBootApplication.class,
            attribute = "scanBasePackages"
    )
    String[] scanBasePackages() default {};

    @AliasFor(
            annotation = SpringBootApplication.class,
            attribute = "scanBasePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};


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



}
