package com.computerdesign.whutHouseMgmt.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author wanhaoran
 * @date 2018年3月10日 下午4:12:06
 * 
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages="com.computerdesign.whutHouseMgmt.controller")
public class SwaggerConfig {

	@Bean
	public Docket api(){
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList<Parameter>();
		tokenPar.name("X-token").description("登陆令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		parameters.add(tokenPar.build());
		return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("房屋管理项目接口文档")
                .description("房屋管理项目接口测试")
                .version("1.0.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
