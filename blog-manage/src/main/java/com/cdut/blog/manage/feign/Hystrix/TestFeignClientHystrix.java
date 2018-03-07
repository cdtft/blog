package com.cdut.blog.manage.feign.Hystrix;

import com.cdut.blog.manage.feign.client.TestFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 15:19 2018/3/2
 */
@Component
public class TestFeignClientHystrix implements TestFeignClient {

    @Override
    public void sayHello() {

    }
}
