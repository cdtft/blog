package com.cdut.mybaits;

import java.sql.Timestamp;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 17:14 2018/3/8
 */
public class BaseEntity {

    private Long id;

    private Timestamp createTime = new Timestamp(System.currentTimeMillis());

    private Timestamp updateTime;
}
