package by.lobanov.training.demos.demo19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheNodeChildren {

    // Заполнить поле children у каждого объекта в списке treeList. Как это сделать?
    static class Node {
        long id; //заполнен
        Long parentId; //заполнен
        List<Node> children; //пустой

        public Node(long id, Long parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public static void main(String[] args) {
        TheNodeChildren fill = new TheNodeChildren();
        List<Node> list = fill.fillChildren();
        for (Node node : list) {
            System.out.println("Node ID: " + node.id + ", Children: " + node.children.size());
        }
    }

    private static List<Node> fillChildren () {
        List<Node> treeList = getList();
        Map<Long, Node> map = new HashMap<>();

        for (int i = 0; i < treeList.size(); i++) {
            Node currentNode = treeList.get(i);
            map.putIfAbsent(currentNode.id, currentNode);
            if (currentNode.children == null) {
                currentNode.children = new ArrayList<>();
            }

            if (map.containsKey(currentNode.parentId)) {
                Node parent = map.get(currentNode.parentId);

                parent.children.add(currentNode);
            }
        }

        return treeList;
    }
    
    private static List<Node> getList() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(1, null));  // Корневой узел
        nodes.add(new Node(2, 1L));    // Дочерний узел для 1
        nodes.add(new Node(3, 1L));    // Дочерний узел для 1
        nodes.add(new Node(4, 2L));    // Дочерний узел для 2
        nodes.add(new Node(5, 2L));    // Дочерний узел для 2
        nodes.add(new Node(6, 3L));    // Дочерний узел для 3

        return nodes;
    }

}
