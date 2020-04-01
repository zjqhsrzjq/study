package com.example.george.study.service.factory.impl;

import com.example.george.study.service.factory.TestAbstractService;
import org.springframework.stereotype.Component;

@Component(value = "third")
public class TestAbstractFirstImpl implements TestAbstractService{

    @Override
    public String say() {
        return "third";
    }
}
