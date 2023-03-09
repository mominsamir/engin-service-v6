package com.engin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<String> getAssetClassCodes() {
        /*        new App().execute(sparkContextManager.getSparkContext(),new String[]{});*/
        return List.of("Samir");
    }
}
