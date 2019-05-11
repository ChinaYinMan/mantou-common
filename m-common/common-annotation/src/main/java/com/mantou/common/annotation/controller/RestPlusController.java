package com.mantou.common.annotation.controller;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * Controller组合注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@RestController
@RequestMapping
public @interface RestPlusController {

    /**------------------------------@RestController注解-------------------------------**/
    @AliasFor(
            annotation = RestController.class,
            attribute = "value"
    )
    String controllerValue() default "";
    /**------------------------------@RestController注解-------------------------------**/



    /**------------------------------@RequestMapping注解-------------------------------**/
    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "path"
    )
    String[] value() default {};


    @AliasFor(
            annotation = RequestMapping.class
    )
    RequestMethod[] method() default {};

    @AliasFor(
            annotation = RequestMapping.class
    )
    String[] params() default {};

    @AliasFor(
            annotation = RequestMapping.class
    )
    String[] headers() default {};

    @AliasFor(
            annotation = RequestMapping.class
    )
    String[] consumes() default {};

    @AliasFor(
            annotation = RequestMapping.class
    )
    String[] produces() default {};

    /**------------------------------@RequestMapping注解-------------------------------**/

}
