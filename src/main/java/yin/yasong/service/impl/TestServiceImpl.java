package yin.yasong.service.impl;

import yin.yasong.annotation.YSService;
import yin.yasong.service.TestService;

@YSService
public class TestServiceImpl implements TestService {

    @Override
    public String printParam(String param) {
        System.out.println("接收到的参数为： "+param);
        return param;
    }
}

