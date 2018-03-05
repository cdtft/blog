package com.cdut.blog.feign.client;

import com.cdut.blog.feign.Hystrix.TestFeignClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 15:15 2018/3/2
 */
@FeignClient(name = "blog-article", fallback = TestFeignClientHystrix.class)
public interface TestFeignClient {

    @RequestMapping(value = "/soa/article/test", method = RequestMethod.POST)
    void sayHello();
}
