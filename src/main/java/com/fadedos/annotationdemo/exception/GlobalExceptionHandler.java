package com.fadedos.annotationdemo.exception;

import com.fadedos.annotationdemo.page.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pengcheng
 * @Description: ${todo}
 * @date 2020/10/24   16:42
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /** 捕捉BizException*/
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public R handle(Exception e) {
        return R.failed(e.getMessage());
    }
}
