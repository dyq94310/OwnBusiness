package com.deng.demo.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")
public interface SchedualServiceHi {

    @GetMapping(value = "/hi/{name}")
    String sayHiFromClientOne(@RequestParam String name);
}
