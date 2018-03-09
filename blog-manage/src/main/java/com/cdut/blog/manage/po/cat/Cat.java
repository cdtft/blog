package com.cdut.blog.manage.po.cat;

import com.cdut.mybaits.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 16:50 2018/3/8
 */
@Getter
@Setter
@ToString
public class Cat extends BaseEntity {

    private String name;

    private Integer gender;

    private Integer age;

}
