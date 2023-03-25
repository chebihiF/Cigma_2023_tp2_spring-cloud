package org.cigma.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator locator (RouteLocatorBuilder builder){
        return builder.routes()
                .route(r-> r.path("/api/v1/customer/**").uri("http://localhost:8090/"))
                .route(r-> r.path("/api/v1/fraud-check/**").uri("http://localhost:8081/"))
                .build();
    }

}
