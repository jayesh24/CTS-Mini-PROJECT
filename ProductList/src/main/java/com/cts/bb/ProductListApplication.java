package com.cts.bb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableSwagger2
public class ProductListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductListApplication.class, args);
		
	}
	
//	@Bean 
//	public Docket swaggerConfiguration()
//	{
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/vapi")).apis(RequestHandlerSelectors.basePackage("com.cts.bb.controller")).build();
//		
//	}

}
