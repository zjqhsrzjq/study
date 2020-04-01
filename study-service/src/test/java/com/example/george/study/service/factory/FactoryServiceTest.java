package com.example.george.study.service.factory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.george.study.service.factory.abstractModel.TestFactoryAbstract;
import com.example.george.study.service.factory.normal.TestFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.george.study.service.BaseServiceTest;
import com.example.george.study.pojo.vo.TestVO;


public class FactoryServiceTest extends BaseServiceTest {
    @Autowired
    TestFactory testFactory;
    @Autowired
    TestFactoryAbstract testFactoryAbstract;

    @Test
    public void test(){
        TestVO result=testFactory.getTest(1).say();

        String a1 = JSONObject.toJSONString(testFactory.getTest(1).say());
        String a2 = JSON.toJSONString(testFactory.getTest(2).say());

        System.out.println(result.getName()+a1+a2);
    }

    @Test
    public void testAbstract(){
        TestVO result=testFactoryAbstract.getTestService(2).say();

        String result2=testFactoryAbstract.getTestAbstractService(4).say();

        System.out.println(result.getName()+result2);
    }
}
