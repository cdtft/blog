package com.cdut.blog.manage.controller.cat;

import com.cdut.blog.manage.service.cat.CatService;
import com.cdut.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:38 2018/3/8
 */
@RestController
@RequestMapping(value = "/api/cat")
public class CatController extends BaseController {

    @Autowired
    private CatService catService;

    @DeleteMapping(value = "/delete/{id}")
    public Map<String, Object> delete(@PathVariable("id") Long id) {
        catService.deleteById(id);
        return buildSuccessMap();
    }
}
