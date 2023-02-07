package cn.ekgc.phenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/7
 */
@SpringBootApplication
public class GatewayStarter {
	public static void main(String[] args) {
		SpringApplication.run(GatewayStarter.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		RouteLocator routeLocator = builder.routes()
				.route(r -> r.path("/system/**").uri("http://localhost:8088")).build();
		return routeLocator;
	}
}
