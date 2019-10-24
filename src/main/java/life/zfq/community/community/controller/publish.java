package life.zfq.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/24 16:52
 */
@Controller
public class publish {
    @GetMapping("/publish")
    public String publish() {

        return "publish";
    }
}
