package com.example.george.study.service.CommonTest;

import com.example.george.study.service.BaseServiceTest;
import com.example.george.study.service.commonStudy.CommonDataType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author George
 * @date 2020/4/6 下午5:06
 */
public class CommonDataTypeTest extends BaseServiceTest{

    @Autowired
    CommonDataType commonDataType;

    @Test
    public void compare(){
        commonDataType.compare();
    }

    @Test
    public void checkError(){
        int a =1;
        a +=1;
        System.out.println(a);
    }
}
