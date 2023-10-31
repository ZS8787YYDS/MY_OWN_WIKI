package com.zisheng.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
public class MyConfiguration implements WebMvcConfigurer {
    /**
     * 通过Knife4j生成接口文档
     * @return
     */
    @Bean
    public Docket docket()
    {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("WIKI接口文档")
                .version("1.0")
                .description("WIKI接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zisheng.Controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    /**
     * 设置静态资源映射,不然是无法访问到doc.html页面的
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
