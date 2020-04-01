package com.example.george.study.service.recursive;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author George
 * @date 2020/4/1 上午1:03
 */
@Component
public class AddChildrenNode {
    private static final String INPUT_PATH  = "/Users/george/a.txt";
    private static final String OUTPUT_PATH = "/Users/george/b.txt";
    @Autowired
    private ReadFile readFile;

    public void process(){
        String fileContent = readFile.toString(INPUT_PATH);
        List<Node> nodeList = buildTree(JSON.parseArray(fileContent,Node.class));
        writeFile(JSON.toJSONString(nodeList).getBytes());
    }



    List<Node> buildTree(List<Node> nodeList){
        List<Node> result = new LinkedList<>();
        nodeList.sort(Comparator.comparing(Node::getId));
        for(Node node:nodeList){
            if(node.getParentId().equals(0L)){
                result.add(addChildrenNode(node,nodeList));
            }
        }
        return result;
    }

    Node addChildrenNode(Node node,List<Node> nodeList){
        for(Node item:nodeList){
            if(node.getId().equals(item.getParentId())){
                node.getChildren().add(addChildrenNode(item,nodeList));
            }
        }
        return node;
    }


    private void writeFile(byte[] content) {
        try {
            OutputStream outputStream = new FileOutputStream(OUTPUT_PATH);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
