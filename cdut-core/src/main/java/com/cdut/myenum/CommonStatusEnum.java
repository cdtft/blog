package com.cdut.myenum;

/**
 * @author : wangcheng
 * @description :
 * @date : Created in 18:19 2018/3/12
 */
public enum CommonStatusEnum {

    ENABLE(1),

    DISABLE(0);

    private int value;

    CommonStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
