package com.github.chinayinman.base.annotation.aop;

import java.lang.annotation.*;

/**
 * AOP切入点注解
 *
 * @author mantou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface Pointcut {

    /**
     * 说明
     *
     * @return
     */
    String message() default "";

}
