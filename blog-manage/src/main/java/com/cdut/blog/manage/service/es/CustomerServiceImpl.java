package com.cdut.blog.manage.service.es;

import com.cdut.blog.manage.domain.es.Customer;
import com.cdut.blog.manage.repository.es.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 23:19 2018/5/21
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveOrUpdate() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setFirstname("wang");
        customer.setLastname("cheng");
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        Page<Customer> page = (Page<Customer>) customerRepository.findAll();
        return page.getContent();
    }
}
