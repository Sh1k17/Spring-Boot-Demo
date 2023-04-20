package com.yjz.springbootdemo.Test.Controller;

import com.yjz.springbootdemo.Test.Service.TestApolloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private TestApolloService testApolloService;

    @GetMapping (value = "/apollo")
    public String testApollo(){
        String result = testApolloService.getApolloApp();
        log.info(String.format("Debugging apollo service: %s", result));
        return result;
    }
}
