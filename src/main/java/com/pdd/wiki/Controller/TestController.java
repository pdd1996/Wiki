package com.pdd.wiki.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.hello:Test}")
    private String testHello;
    /*
    常用 GET, POST, PUT, DELETE
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello Post " + name;
    }
}
