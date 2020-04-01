package com.example.george.study.service.recursive;

import com.example.george.study.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author George
 * @date 2020/4/1 上午1:20
 */
public class CommonTest extends BaseServiceTest{
    @Autowired
    AddChildrenNode addChildrenNode;
    @Autowired
    FindChild findChild;

    @Test
    public void test(){
        addChildrenNode.process();
    }

    @Test
    public void test2(){
        findChild.process();
    }
}
