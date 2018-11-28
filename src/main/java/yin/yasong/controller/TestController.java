package yin.yasong.controller;

import yin.yasong.annotation.YSAutowired;
import yin.yasong.annotation.YSController;
import yin.yasong.annotation.YSRequestMapping;
import yin.yasong.annotation.YSRequestParam;
import yin.yasong.service.TestService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@YSController
@YSRequestMapping("/test")
public class TestController {

    @YSAutowired
    TestService testService;

    @YSRequestMapping("/info")
    public String getInfo(@YSRequestParam("info") String info, HttpServletResponse response){

        try {

            String name = testService.printParam(info);
            response.getWriter().write( "This is Test :"+name);

            return name;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
