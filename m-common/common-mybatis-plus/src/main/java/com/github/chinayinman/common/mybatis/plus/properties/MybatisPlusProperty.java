package com.github.chinayinman.common.mybatis.plus.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Mybatis-plus Property
 *
 * @author mantou
 */
@Data
@Component
@ConfigurationProperties(prefix = "mantou-mybatis-plus")
public class MybatisPlusProperty {


    /**
     * Sql执行效率插件
     */
    @Data
    @Component
    public class PerformanceInterceptor {

        /**
         * 最大执行时长: 默认1秒
         */
        public long maxTime = 1000;

        /**
         * 是否格式化SQL: 默认false
         */
        public Boolean format = false;

    }


    /**
     * 分页插件
     */
    @Data
    @Component
    public class PaginationInterceptor {

        /**
         * 方言类型: 默认 mysql
         */
        private String dialectType = "mysql";

    }

}
