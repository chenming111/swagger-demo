package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2   //开启swagger
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("a");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("b");
    }

    //配置了swagger的docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("111")
                .enable(true)
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any:全部扫描
                //none：不扫描
                //withclassAnnotation:扫描类上的注解
                //withmethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller")).build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact =new Contact("陈明","http://localhost:8080","543428992@qq.com");
        return new ApiInfo("陈明的Api文档",
                "努力就有收获",
                "1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());


    }

}
