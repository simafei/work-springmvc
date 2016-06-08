package com.facishare.operation.webportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by fengpj on 2016/6/1.
 */
@Controller
public class IndexController {

    @Resource
    private QueryService queryService;

    @RequestMapping("/test")
    public String test() {
        return "index";
    }

    @RequestMapping("mv")
    public ModelAndView mv() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("results", queryService.find("SELECT * FROM app_usage_app_data"));
        return mv;
    }
}
