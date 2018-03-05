package com.cdut.exception;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 20:52 2018/3/5
 */
public class BlogException extends RuntimeException {

    /**
     * 状态码
     */
    private int code;

    public BlogException() {
        super();
    }

    public BlogException(String msg) {
        super(msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
