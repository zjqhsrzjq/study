package com.example.george.study.service.factory.impl;

import com.example.george.study.service.factory.TestAbstractService;
import org.springframework.stereotype.Component;

@Component(value = "fourth")
public class TestAbstractSecondImpl implements TestAbstractService {

    @Override
    public String say() {
        return "fourth";
    }
}
