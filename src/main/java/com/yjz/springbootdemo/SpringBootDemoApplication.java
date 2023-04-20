package com.yjz.springbootdemo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class SpringBootDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringBootDemoApplication.class, args);
        log.info("-----Spring-----Boot-----Application-----Starts");
    }

}
