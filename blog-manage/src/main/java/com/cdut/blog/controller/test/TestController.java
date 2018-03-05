package com.cdut.blog.controller.test;

import com.cdut.blog.feign.client.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 15:09 2018/3/2
 */

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestFeignClient testFeignClient;

    @GetMapping("hello")
    public String sayHello() {
        testFeignClient.sayHello();
        return "hello";
    }
}
