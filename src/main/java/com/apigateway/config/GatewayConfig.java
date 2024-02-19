package com.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator preorderRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/user/**")
                        .uri("http://localhost:8080"))
                .route("activity-service", r -> r.path("/activity/**")
                        .uri("http://localhost:8081"))
                .route("news-feed-service", r -> r.path("/newsfeed/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
