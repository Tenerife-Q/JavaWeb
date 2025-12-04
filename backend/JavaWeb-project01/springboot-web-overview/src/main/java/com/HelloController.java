package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/18 14:17
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("name: " + name);
        return "Hello " + name + "~";
    }
}
