package com.cdut.blog.manage.service.cat;

import com.cdut.blog.manage.repository.cat.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:42 2018/3/8
 */
@Service
public class CatServiceImpl implements CatService {


    @Autowired
    private CatMapper catMapper;

    @Override
    public void deleteById(Long id) {
        catMapper.delete(id);
    }
}
