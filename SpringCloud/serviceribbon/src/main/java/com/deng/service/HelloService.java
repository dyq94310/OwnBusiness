package com.deng.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author DengYongQi
 * @date 2019-07-07
 **/
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiServiceFallback")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi/" + name, String.class);
    }

    private String hiServiceFallback(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
