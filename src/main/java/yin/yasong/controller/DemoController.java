package yin.yasong.controller;

import yin.yasong.annotation.YSAutowired;
import yin.yasong.annotation.YSController;
import yin.yasong.annotation.YSRequestMapping;
import yin.yasong.annotation.YSRequestParam;
import yin.yasong.service.TestService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@YSController
@YSRequestMapping("/demo")
public class DemoController {

    @YSAutowired
    TestService testService;

    @YSRequestMapping("/info")
//    @ResponseBody
    public String getInfo(@YSRequestParam("name") String name , HttpServletResponse response){

        try {
            response.getWriter().write( "Test1Controller:the param you send is :"+name);
            String info = testService.printParam(name);
            System.out.println("+++++++++++++++++++++testService.printParam(name) " + info);

            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @YSRequestMapping("/name")
    public String getInfo(@YSRequestParam("name") String name){

        String info = testService.printParam(name);
        return info;
    }
}
