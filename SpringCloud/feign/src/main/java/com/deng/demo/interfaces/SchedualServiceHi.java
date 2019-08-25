package com.deng.demo.interfaces;

import com.deng.demo.interfaces.fallback.SchedualServiceHiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = SchedualServiceHiFallBack.class)
public interface SchedualServiceHi {

    @GetMapping(value = "/hi/{name}")
    String sayHiFromClientOne(@RequestParam String name);
}
