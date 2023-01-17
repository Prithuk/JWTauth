package com.jwt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Hello JWT";
    }

    @RequestMapping(value = "/sum/{a}/{b}", method = RequestMethod.POST)
    public int addSUm(@PathVariable int a, @PathVariable int b) {
        int sum = a + b;
        return sum;
    }
}
