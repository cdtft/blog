package com.cdut.blog.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 15:32 2018/3/2
 */
@Controller
@RequestMapping("/soa/article")
public class TestController {

    @PostMapping("test")
    public void sayHello() {
        System.out.print("article sya hello!");

    }
}
