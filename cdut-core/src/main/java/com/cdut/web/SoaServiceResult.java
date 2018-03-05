package com.cdut.web;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author : wangcheng
 * @description : manage后端统一返回对象
 * @date : Created in 16:23 2018/3/2
 */
public class SoaServiceResult<T> implements Serializable {

    private static final int SUCCESS_CODE = 200;

    private static final int ERROR_CODE = 500;


    /**
     * 状态码
     */
    private int status;

    /**
     * 调用信息
     */
    private String msg;

    /**
     * data
     */
    private T data;

    /**
     *返回异常
     */
    @JsonIgnore
    private Exception e;

    public static <T> SoaServiceResult<T> buildSuccess() {
        SoaServiceResult<T> result = new SoaServiceResult<>();
        result.setStatus(SUCCESS_CODE);
        return result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
}
