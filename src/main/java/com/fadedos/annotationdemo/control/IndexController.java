package com.fadedos.annotationdemo.control;

import com.fadedos.annotationdemo.annotation.LoginRequired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengcheng
 * @Description: ${todo}
 * @date 2020/10/23   19:34
 */
@RestController
public class IndexController {
    @RequestMapping("/sourceA")
    public String sourceA() {
        return "你正在访问A资源";
    }

    @RequestMapping("/sourceB")
    @LoginRequired
    public String sourceB() {
        return "你正在访问B资源";
    }
}
