package life.zfq.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/12 21:38
 */
@Controller
public class ProfileController {
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model){
        if("questions".equals(action)){
            model.addAttribute("selection","questions");
            model.addAttribute("selectionName","我的问题");
        }else if("replies".equals(action)){
            model.addAttribute("selection","replies");
            model.addAttribute("selectionName","最新消息");
        }
        return  "/profile";
    }
}
