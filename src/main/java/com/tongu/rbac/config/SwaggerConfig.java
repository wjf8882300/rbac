package com.tongu.rbac.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * 
 * @author wangjf
 * @date 2019年4月16日 下午1:49:58
 */
@Profile("!prod")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private SwaggerProperties swagger;

	@Bean
	public Docket getApiConfig() {
		List<Parameter> pars = new ArrayList<Parameter>();
		ParameterBuilder tokenParam = new ParameterBuilder();
		tokenParam.name("X-Auth-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		ParameterBuilder clientParam = new ParameterBuilder();
		clientParam.name("clientType").description("客户端类型[0-pc/1-android/2-iOS]").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		pars.add(tokenParam.build());
		pars.add(clientParam.build());

		return new Docket(DocumentationType.SWAGGER_2).host(swagger.getHost()).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.smartxoffice.provider.oa.auth.controller"))
				.paths(PathSelectors.any()).build().globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AUTH服务").version("1.0").build();
	}

	@Bean
    UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()
		.deepLinking(true)
        .displayOperationId(false)
        .defaultModelsExpandDepth(1)
        .defaultModelExpandDepth(1)
        .defaultModelRendering(ModelRendering.EXAMPLE)
        .displayRequestDuration(false)
        .docExpansion(DocExpansion.NONE)
        .filter(false)
        .maxDisplayedTags(null)
        .operationsSorter(OperationsSorter.ALPHA)
        .showExtensions(false)
        .tagsSorter(TagsSorter.ALPHA)
        .validatorUrl(null)
        .build();
    }
}
