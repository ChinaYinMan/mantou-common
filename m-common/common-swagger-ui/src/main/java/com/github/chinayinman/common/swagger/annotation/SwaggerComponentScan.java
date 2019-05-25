package com.github.chinayinman.common.swagger.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Swagger扫描
 * @author mantou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan
public @interface SwaggerComponentScan {

    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackages"
    )
    String[] swaggerScanPath() default {};
}
