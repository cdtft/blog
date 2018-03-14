package com.cdut.search.mongodb.base;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * MongoDB基本操作类.
 * 
 * @author : Zilean
 * @date : 2018-03-13 15:44
 */
public class CommonMongoOperation {

    /**
     * 通过集合的某个 key 查找到为value的记录.
     * 
     * @param template
     *            MongoTemplate
     * @param key
     *            集合 key
     * @param value
     *            需要查找的值
     * @param entityClass
     *            MongoDB集合对应的 Bean 类
     * @return 查找到的记录
     */
    public static List<?> find(MongoTemplate template, String key, Object value, Class<?> entityClass) {
        Criteria criteria = Criteria.where(key).is(value);
        Query query = new Query(criteria);
        return template.find(query, entityClass);
    }

    /**
     * 通过集合的某个 key 查找到为value的记录,分页获取值.
     * 
     * @param template
     *            MongoTemplate
     * @param key
     *            集合 key
     * @param value
     *            需要查找的值
     * @param entityClass
     *            MongoDB集合对应的 Bean 类
     * @param pageNo
     *            第几页，默认从0开始
     * @param pageSize
     *            每页大小
     * @return 查找到的记录
     */
    public static List<?> find(MongoTemplate template, String key, Object value, Class<?> entityClass, int pageNo,
            int pageSize) {
        Criteria criteria = Criteria.where(key).is(value);
        Query query = new Query(criteria);
        return template.find(query.skip(pageNo * pageSize).limit(pageSize), entityClass);
    }

    /**
     * 保存一条记录.
     * 
     * @param template
     *            MongoTemplate
     * @param entityClass
     *            实体类
     */
    public static void save(MongoTemplate template, Object object) {
        template.save(object);
    }

    /**
     * 删除某条记录，以这种方式删除的时候，该记录应该已知 id.
     * 
     * @param template
     *            MongoTemplate
     * @param entityClass
     *            实体类
     */
    public static void delete(MongoTemplate template, Object object) {
        template.remove(object);
    }

    /**
     * 删除符合某个 key-value 组合的所有记录.
     * 
     * @param template
     *            MongoTemplate
     * @param key
     *            集合 key
     * @param value
     *            需要删除的值
     * @param entityClass
     *            实体类
     */
    public static void delete(MongoTemplate template, String key, Object value, Class<?> entityClass) {
        Criteria criteria = Criteria.where(key).is(value);
        Query query = new Query(criteria);
        template.remove(query, entityClass);
    }
}
