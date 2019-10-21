package life.zfq.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/20 18:52
 * version 2.0
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {

        return "index";
    }
}
