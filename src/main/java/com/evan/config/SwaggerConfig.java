package com.evan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author evanYang
 * @version 1.0
 * @date 09/29/2019 11:30
 */
@Configuration
@EnableSwagger2
@Profile({"dev","test","local"})
public class SwaggerConfig {


     @Bean
    public Docket api() {
         ParameterBuilder ticketPar = new ParameterBuilder();
         ParameterBuilder ticketParAppType = new ParameterBuilder();
         List<Parameter> pars = new ArrayList<Parameter>();
         ticketPar.name("UUID").description("手机唯一标识")//name表示名称，description表示描述
                 .modelRef(new ModelRef("string")).parameterType("header")
                 //.required(false).build();
                 .required(false).defaultValue("uuid").build();//required表示是否必填，defaultvalue表示默认值
         ticketParAppType.name("appType").description("app类型")//name表示名称，description表示描述
                 .modelRef(new ModelRef("string")).parameterType("header")
                 //.required(false).build();
                 .required(false).defaultValue("tpi").build();//required表示是否必填，defaultvalue表示默认值
         pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效
         pars.add(ticketParAppType.build());

        return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .globalOperationParameters(pars)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("客户端文档")
                .description("客户端api文档")
//                .termsOfServiceUrl("/")
                .version("1.0")
                .build();
    }
    private List<ApiKey> securitySchemes() {
        ArrayList arrayList = new ArrayList(Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
        //arrayList.add(Collections.singleton(new ApiKey("UUID", "UUID", "header")));
        return arrayList;
    }
    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        );
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        ArrayList authorization = new ArrayList(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
        //authorization.add(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
        return authorization;
    }

    public static void main(String[] args) {
    }
}
