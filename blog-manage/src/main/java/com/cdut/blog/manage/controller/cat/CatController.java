package com.cdut.blog.manage.controller.cat;

import com.cdut.blog.manage.service.cat.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:38 2018/3/8
 */
@Controller
@RequestMapping(value = "cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        catService.deleteById(id);
    }
}
