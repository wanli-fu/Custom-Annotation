package com.fadedos.annotationdemo.exception;

/**
 * @author pengcheng
 * @Description: ${todo}
 * @date 2020/10/23   19:57
 */
public class BizException extends RuntimeException {
    public BizException(String msg) {
        super(msg);
    }
    public BizException() {
        super();
    }
}
