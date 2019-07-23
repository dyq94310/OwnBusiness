package com.deng.demo.controller;

import com.deng.demo.interfaces.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DengYongQi
 * @date 2019-07-23
 **/
@RestController
public class HiController {
    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
