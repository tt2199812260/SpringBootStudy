package com.mingdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    分组@B
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    //配置Swagger的Docket 的bean 实例
    @Bean
    public Docket docket(Environment environment){
        //获取项目环境
        Profiles profiles = Profiles.of("dev");
        Boolean flag = environment.acceptsProfiles(profiles);

        return  new Docket(DocumentationType.SWAGGER_2).groupName("MingDEV")
                .enable(true) //swagger是否启用
                .select()
                /*
                RequestHandlerSelectors //配置要扫描接口的方式
                * .any()  扫描全部
                * .none() 不扫描
                * .basePackage("com.mingdev.controller") 指定要扫描的包
                * .withClassAnnotation  扫描类上面的注解，参数是一个注解的反射对象(XX.class)
                * .withMethodAnnotation   扫描方法上的注解(XX.class)
                */
                .apis(RequestHandlerSelectors.basePackage("com.mingdev.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){

        return new ApiInfo(
                "Mngdev 的 API文档",
                "新手上路，请多关照",
                "v 1.0",
                "https://bailey.pinruikm.com/",
                new Contact("MingDev", "https://bailey.pinruikm.com/", "2199812260@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }


}
