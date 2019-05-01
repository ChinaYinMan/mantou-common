package com.mantou.common.mybatis.plus.mybatisplus;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Mybatis-plus 配置类
 * @author mantou
 */
@Data
@Component
@ConfigurationProperties(prefix = "manout-mybatis-plus")
public class MybatisPlusProperties {


    /**
     * SQL执行效率插件
     */
    @Data
    @Component
    public class PerformanceInterceptor {

        /**
         * Sql最大执行时长: 默认1秒
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
         * 方言类型
         */
        private String dialectType;

    }

}
