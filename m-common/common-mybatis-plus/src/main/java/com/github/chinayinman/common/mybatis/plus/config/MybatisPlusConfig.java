package com.github.chinayinman.common.mybatis.plus.config;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.github.chinayinman.common.mybatis.plus.properties.MybatisPlusProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类
 *
 * @author mantou
 */
@Configuration
@EnableConfigurationProperties(MybatisPlusProperty.class)
public class MybatisPlusConfig {


    @Autowired
    private MybatisPlusProperty.PerformanceInterceptor performanceInterceptor;

    @Autowired
    private MybatisPlusProperty.PaginationInterceptor paginationInterceptor;


    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {

        //SQL 执行性能分析，开发环境使用，线上不推荐
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //SQL是否格式化 默认false
        performanceInterceptor.setFormat(this.performanceInterceptor.getFormat());
        //maxTime 指的是 sql 最大执行时长
        performanceInterceptor.setMaxTime(this.performanceInterceptor.getMaxTime());

        return performanceInterceptor;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        String dialectType = this.paginationInterceptor.getDialectType();
        if (StringUtils.isNotEmpty(dialectType)) {
            //指定方言(方言: 数据库特有的语义, 不能移植至其他数据库; 例如MySQL当中的limit)
            paginationInterceptor.setDialectType(dialectType);
        }
        return paginationInterceptor;
    }

}
