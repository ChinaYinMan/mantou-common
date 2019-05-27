package com.github.chinayinman.cloud.annotation.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * SpringCloudPlusApplication 组合注解
 *
 * @author mantou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringCloudApplication
@EnableAutoConfiguration
public @interface SpringCloudPlusApplication {

    /**
     * -----------------------@EnableAutoConfiguration----------------------------
     **/
    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    Class<?>[] exclude() default {};

    @AliasFor(
            annotation = EnableAutoConfiguration.class
    )
    String[] excludeName() default {};

    /**-----------------------@EnableAutoConfiguration----------------------------**/

    /**
     * ---------------------------@ComponentScan----------------------------------
     **/
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
    /**---------------------------@ComponentScan----------------------------------**/

}
