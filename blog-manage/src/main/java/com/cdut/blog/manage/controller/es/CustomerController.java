package com.cdut.blog.manage.controller.es;

import com.cdut.blog.manage.domain.es.Customer;
import com.cdut.blog.manage.service.es.CustomerService;
import com.cdut.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 23:23 2018/5/21
 */
@RestController
@RequestMapping(value = "/api/es")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Map<String, Object> saveOrUpdateCustomer() {
        customerService.saveOrUpdate();
        return this.buildSuccessMap();
    }

    @GetMapping("/customers")
    public Map<String, Object> getAllCustomers() {

        List<Customer> list = customerService.findAll();
        return renderResultMap(HttpStatus.OK.value(), "success", list);
    }
}

