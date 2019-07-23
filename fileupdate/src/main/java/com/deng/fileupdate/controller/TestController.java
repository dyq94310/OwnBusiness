package com.deng.fileupdate.controller;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

/**
 * @author DengYongQi
 * @date 2019-07-14
 **/
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

}
