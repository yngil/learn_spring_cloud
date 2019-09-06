package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Value("#{'${user.name}'}")
    private String userName;

    @RequestMapping("/echo")
    public String echo(){
        return "Hello," + userName;
    }
}
