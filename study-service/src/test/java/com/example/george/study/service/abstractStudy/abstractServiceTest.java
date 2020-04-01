package com.example.george.study.service.abstractStudy;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class abstractServiceTest {


    @Test
    public void test(){
        TestChild testChild = new TestChild("George",30,"Alibaba");

        System.out.println(JSONObject.toJSONString(testChild));
    }

}
