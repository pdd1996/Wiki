package com.pdd.wiki.controller;

import com.pdd.wiki.domain.Animal;
import com.pdd.wiki.domain.Test;
import com.pdd.wiki.service.AnimalService;
import com.pdd.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private TestService testService;

    @Resource
    private AnimalService animalService;
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

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }

    @GetMapping("/test/animal")
    public List<Animal> animalList() {
        return animalService.animalList();
    }
}
