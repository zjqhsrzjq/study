package com.example.george.study.service.recursive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author George
 * @date 2020/4/1 上午1:15
 */
@Component
public class FindChild {
      private static final String PATH = "/Users/george/b.txt";

    @Autowired
    private ReadFile readFile;


    public Node process(){
        List<Node> nodeList = JSON.parseArray(readFile.toString(PATH),Node.class);
        Node node = findNode(nodeList,"A23");
        return node;
    }

    Node findNode(List<Node> list,String name){
        for(Node node:list){
            if(name.equals(node.getName())){
                return node;
            }
            if(null != node.getChildren() && node.getChildren().size()>0){
                return findNode(node.getChildren(),name);
            }

        }
        return null;
    }
}
