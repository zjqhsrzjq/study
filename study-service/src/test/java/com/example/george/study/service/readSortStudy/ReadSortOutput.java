package com.example.george.study.service.readSortStudy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author George
 * @date 2020/3/31 下午10:18
 */
public class ReadSortOutput {

    private static final String INPUT_PATH  = "/Users/george/a.txt";
    private static final String OUTPUT_PATH = "/Users/george/d.txt";

    @Test
    public void test() {
        String fileContent = read();
        List<Node> nodeList = parse(fileContent);
        if(null !=nodeList && nodeList.size()>0){
            nodeList = buildTree(nodeList);
        }
        write(JSON.toJSONString(nodeList).getBytes());
    }

    String read(){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(INPUT_PATH));
            String line;
            while ((line= br.readLine())!=null){
                sb.append(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    List<Node> parse(String input){
        List<Node> list = new LinkedList<>();
        try{
            list = JSON.parseArray(input, Node.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
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


    private void write(byte[] content) {
        try {
            OutputStream outputStream = new FileOutputStream(OUTPUT_PATH);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class Node {
        private Long id;
        private String name;
        private Long parentId;
        private List<Node> children;

        public Node(long id, String name, long parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
            this.children = new LinkedList<>();
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Node> getChildren() {
            return children;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }

    public void testAutoClose(){

    }

}
