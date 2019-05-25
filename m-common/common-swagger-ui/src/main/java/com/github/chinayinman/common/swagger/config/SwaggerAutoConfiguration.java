
package com.github.chinayinman.common.swagger.config;


import com.github.chinayinman.common.swagger.property.SwaggerProperty;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * swagger配置
 *
 * @author mantou
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Profile({"dev", "test"})
@EnableConfigurationProperties(SwaggerProperty.class)
public class SwaggerAutoConfiguration {

    private static final String DEFAULT_EXCLUDE_PATH = "/error";
    private static final String BASE_PATH = "/**";


    @Autowired
    private SwaggerProperty swaggerProperty;

    @Bean
    public Docket api() {
        // base-path处理
        if (swaggerProperty.getBasePath().size() == 0) {
            swaggerProperty.getBasePath().add(BASE_PATH);
        }
        //noinspection unchecked
        List<Predicate<String>> basePath = new ArrayList();
        swaggerProperty.getBasePath().forEach(path -> basePath.add(PathSelectors.ant(path)));

        // exclude-path处理
        if (swaggerProperty.getExcludePath().size() == 0) {
            swaggerProperty.getExcludePath().add(DEFAULT_EXCLUDE_PATH);
        }
        List<Predicate<String>> excludePath = new ArrayList<>();
        swaggerProperty.getExcludePath().forEach(path -> excludePath.add(PathSelectors.ant(path)));

        //noinspection Guava
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperty.getHost())
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .build()
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()))
                .pathMapping("/");
    }

    /**
     * 配置默认的全局鉴权策略的开关，通过正则表达式进行匹配；默认匹配所有URL
     *
     * @return
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(swaggerProperty.getAuthorization().getAuthRegex()))
                .build();
    }

    /**
     * 默认的全局鉴权策略
     *
     * @return
     */
    private List<SecurityReference> defaultAuth() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        swaggerProperty.getAuthorization().getAuthorizationScopeList().forEach(authorizationScope -> authorizationScopeList.add(new AuthorizationScope(authorizationScope.getScope(), authorizationScope.getDescription())));
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[authorizationScopeList.size()];
        return Collections.singletonList(SecurityReference.builder()
                .reference(swaggerProperty.getAuthorization().getName())
                .scopes(authorizationScopeList.toArray(authorizationScopes))
                .build());
    }


    private OAuth securitySchema() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        swaggerProperty.getAuthorization().getAuthorizationScopeList().forEach(authorizationScope -> authorizationScopeList.add(new AuthorizationScope(authorizationScope.getScope(), authorizationScope.getDescription())));
        ArrayList<GrantType> grantTypes = new ArrayList<>();
        swaggerProperty.getAuthorization().getTokenUrlList().forEach(tokenUrl -> grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(tokenUrl)));
        return new OAuth(swaggerProperty.getAuthorization().getName(), authorizationScopeList, grantTypes);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperty.getTitle())
                .description(swaggerProperty.getDescription())
                .license(swaggerProperty.getLicense())
                .licenseUrl(swaggerProperty.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperty.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperty.getContact().getName(), swaggerProperty.getContact().getUrl(), swaggerProperty.getContact().getEmail()))
                .version(swaggerProperty.getVersion())
                .build();
    }

}
