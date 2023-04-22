package com.yjz.springbootdemo.Test.Controller;

import com.yjz.springbootdemo.Test.Service.TestApolloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private TestApolloService testApolloService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping (value = "/apollo")
    public String testApollo(){
        String result = testApolloService.getApolloApp();
        log.info(String.format("Debugging apollo service: %s", result));
        return result;
    }

    @Transactional
    @RequestMapping("/send")
    public void send() {
        kafkaTemplate.send("test", "key", "测试kafka消息");
    }
}
