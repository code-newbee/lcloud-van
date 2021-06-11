package lcloud.van;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/26 14:36
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VanAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(VanAuthApplication.class,args);
    }
}
