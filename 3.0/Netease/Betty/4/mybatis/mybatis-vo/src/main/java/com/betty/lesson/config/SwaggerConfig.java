package com.betty.lesson.config;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName SwaggerConfig.java
 * @Description TODO
 * @createTime 2020年05月22日 13:00:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger2.enable}")
    private boolean enable;
    @Bean
    public Docket createRestApi() {
        /**
         * 添加头部信息
         */
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar=new ParameterBuilder();
        tokenPar.name("token").description("swagger测试用(模拟token传入)非必填 header").modelRef(new ModelRef("string")).parameterType("header").required(false);
        /**
         * 多个直接加到pars
         */
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.betty.lesson.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring boot2.x实战")
                .description("spring boot2.x 零基础到高级实战系列")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
