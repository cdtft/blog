package com.cdut.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wangcheng
 * @description : manage中controller基类
 * @date : Created in 20:45 2018/3/14
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /*public <T> T parseDataFromHttpRequest(HttpServletRequest request, Class<T> clazz) {

    }*/

    protected Map<String, Object> renderResultMap(Integer code, String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", message);
        result.put("data", data);
        return result;
    }

    protected Map<String, Object> buildSuccessMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.OK.value());
        return result;
    }
}
