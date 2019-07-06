package com.deng.service.eurekaclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DengYongQi
 * @date 2019-07-07
 **/
@RestController
public class TestService {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi/{name}")
    public String home(@PathVariable("name") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
