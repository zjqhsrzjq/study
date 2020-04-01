package com.example.george.study.service.factory.abstractModel;

import com.example.george.study.service.factory.TestAbstractService;
import com.example.george.study.service.factory.TestService;


public abstract class AbstractFactory {

    public abstract TestService getTestService(Integer num);

    public abstract TestAbstractService getTestAbstractService(Integer num);
}
