package com.own.business.qrcode.controller;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 测试类
 *
 * @author DengYongQi
 * @date 2018-12-26 15:44
 **/
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class QrControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new QrController()).build();
    }

    @Test
    public void testHello() throws Exception {
        String responseString = mvc.perform(MockMvcRequestBuilders.get("/qr/")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + responseString);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("index", "1");
        jsonObject.put("contents", "hello");
        jsonObject.put("width", "100");
        jsonObject.put("height", "200");

        String contentAsString = mvc.perform(MockMvcRequestBuilders.post("/qr/image").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonObject.toJSONString())).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + contentAsString);

        responseString = mvc.perform(MockMvcRequestBuilders.get("/qr/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + responseString);

        jsonObject.put("contents", "helloWorld");
        contentAsString = mvc.perform(MockMvcRequestBuilders.put("/qr/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonObject.toJSONString())).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + contentAsString);


        responseString = mvc.perform(MockMvcRequestBuilders.get("/qr/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + responseString);

        contentAsString = mvc.perform(MockMvcRequestBuilders.delete("/qr/1")).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + contentAsString);

        responseString = mvc.perform(MockMvcRequestBuilders.get("/qr/")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("--------All返回的json = " + responseString);

    }

    @Test
    public void testExc() throws Exception {

        String contentAsString = mvc.perform(MockMvcRequestBuilders.post("/qr/jexception").contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("--------返回的json = " + contentAsString);

    }

}
