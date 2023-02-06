package cn.ekgc.phenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b></b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EmrConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(EmrConsumerStarter.class, args);
	}
}
