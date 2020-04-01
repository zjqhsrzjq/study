package com.example.george.study.service.readSortStudy;

import com.alibaba.fastjson.annotation.JSONField;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author George
 * @date 2020/3/31 下午11:00
 */
public class testTest {
    private static final String SRC_FILE_PATH  = "/Users/george/a.txt";
    private static final String DEST_FILE_PATH = "/Users/george/c.txt";

    @Test
    public void process() {
        byte[] fileContent = readFile(SRC_FILE_PATH);
        List<Node> nodeList = convertToNodeList(fileContent);
        Node[] sortedNodes = sortNodes(nodeList);
        linkParentAndChild(sortedNodes);
        NodeTree nodeTree = generateNodeTree(sortedNodes);
        writeFile(com.alibaba.fastjson.JSONObject.toJSONString(nodeTree.getNodes()).getBytes());
    }

    // 读文件
    public byte[] readFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

     class read implements AutoCloseable{

        @Override
        public void close() {
            System.out.println("close");
        }
    }

    // 文件内容转换为List<node>
    public List<Node> convertToNodeList(byte[] bytes) {
        String content = new String(bytes);
        List<Node> nodes = com.alibaba.fastjson.JSON.parseArray(content, Node.class);
        return nodes;
    }

    // 将List<Node>排序， 转换为Node[] 提升查找效率
    public Node[] sortNodes(List<Node> nodes) {
        Node[] sortedNodes = new Node[nodes.size() + 2];
        nodes.forEach(e -> sortedNodes[(int)e.getId()] = e);
        return sortedNodes;
    }

    // 遍历Node[] 链接所有父子关系
    public void linkParentAndChild(Node[] sortedNodes) {
        for (int i=1;i<sortedNodes.length;i++) {
            if (sortedNodes[i] == null) {
                continue;
            }
            long parentId = sortedNodes[i].getParentId();
            if (parentId != 0) {
                sortedNodes[(int)parentId].addChildren(sortedNodes[i]);
            }
        }
    }

    // 根据Node[] 输出 NodeTree
    public NodeTree generateNodeTree(Node[] nodes) {
        List<Node> result = new LinkedList<>();
        for (int i=1;i<nodes.length;i++){
            if (nodes[i] == null) {
                continue;
            }
            // NodeTree的节点为所有parentId为0(没有parent)的节点
            if (nodes[i].getParentId() == 0) {
                result.add(nodes[i]);
            }
        }
        return new NodeTree(result);
    }

    public void writeFile(byte[] content) {
        try (OutputStream outputStream = new FileOutputStream(DEST_FILE_PATH)) {
            outputStream.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class NodeTree {
        private List<Node> nodes;
        public NodeTree(List<Node> nodes) {
            this.nodes = nodes;
        }

        public List<Node> getNodes() {
            return this.nodes;
        }
    }


    public class Node {
        private long id;
        private String name;
        private long parentId;
        private List<Node> children;

        public Node(long id, String name, long parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
            this.children = new LinkedList<>();
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Node> getChildren() {
            return children;
        }

        @JSONField(name = "parent_id")
        public long getParentId() {
            return parentId;
        }

        public void addChildren(Node node) {
            this.children.add(node);
        }

        @JSONField(serialize = false)
        public int getChildrenCount() {
            return this.children.size();
        }
    }

}
