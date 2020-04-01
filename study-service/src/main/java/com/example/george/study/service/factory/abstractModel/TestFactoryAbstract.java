package com.example.george.study.service.factory.abstractModel;

import com.example.george.study.common.enums.TestFactoryType;
import com.example.george.study.service.factory.TestAbstractService;
import com.example.george.study.service.factory.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestFactoryAbstract extends AbstractFactory {

    @Autowired
    private Map<String,TestService> testService = new HashMap<>();

    @Autowired
    private Map<String,TestAbstractService> testAbstractService = new HashMap<>();

    @Override
    public TestService getTestService(Integer num) {
        if(TestFactoryType.getDesc(num) != null){
            return this.testService.get(TestFactoryType.getDesc(num));
        }
        return null;
    }

    @Override
    public TestAbstractService getTestAbstractService(Integer num) {
        if(TestFactoryType.getDesc(num) != null){
            return this.testAbstractService.get(TestFactoryType.getDesc(num));
        }
        return null;
    }
}
