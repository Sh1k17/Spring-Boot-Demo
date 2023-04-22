package com.yjz.springbootdemo.Test.Service;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestApolloService {

    @ApolloConfig
    private  Config config;

    public String getApolloApp() {
        Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        String someKey = "portal.yjz.password";
        String someDefaultValue = "shiki";
        String value = config.getProperty(someKey, someDefaultValue);
        return value;
    }


}
