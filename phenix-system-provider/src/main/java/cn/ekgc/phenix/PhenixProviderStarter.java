package cn.ekgc.phenix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b>系统功能模块- provider -启动类</b>
 *
 * @author JLS
 * @date 2023/2/6
 */
@MapperScan("cn.ekgc.phenix.*.*.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class PhenixProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(PhenixProviderStarter.class, args);
	}
}
