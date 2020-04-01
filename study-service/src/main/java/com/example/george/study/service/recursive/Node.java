package com.example.george.study.service.recursive;

import java.util.LinkedList;
import java.util.List;

/**
 * @author George
 * @date 2020/4/1 上午1:04
 */
public class Node {
    private Long id;
    private String name;
    private Long parentId;
    private List<Node> children =new LinkedList<>();

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

    public void addChildren(Node node) {
        this.children.add(node);
    }

    @Override
    public String toString(){
        return "Node{"+
                "id="+id+'\''+
                "name="+name+'\''+
                "parentId="+parentId+'\''+
                "children="+children+'\''+
                '}';
    }
}