package com.plas.qw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/27/11:16
 * @Description:
 */
//@CrossOrigin(origins = "*", maxAge = 3600) //解决跨域问题
@Controller
public class indexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }


}
