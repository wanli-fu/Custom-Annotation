package com.fadedos.annotationdemo.page;

import com.fadedos.annotationdemo.consts.CommonConst;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author pengcheng
 * @Description: ${todo}
 * @date 2020/10/24   16:43
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public static <T> R<T> ok() {
        return restResult(null, CommonConst.SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, CommonConst.SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, CommonConst.SUCCESS, msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, CommonConst.FAIL, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, CommonConst.FAIL, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, CommonConst.FAIL, null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, CommonConst.FAIL, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }
}
