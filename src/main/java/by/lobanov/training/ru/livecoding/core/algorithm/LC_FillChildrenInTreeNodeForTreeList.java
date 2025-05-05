package by.lobanov.training.ru.livecoding.core.algorithm;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
1. Заполнить поле children у каждого объекта в списке treeList.
 */
public class LC_FillChildrenInTreeNodeForTreeList {

    @RequiredArgsConstructor()
    @ToString
    static class Node {
        final long id; //заполнен
        final Long parentId; //заполнен
        List<Node> children; //пустой
    }

    private List<Node> getList() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(1, null));  // Корневой узел
        nodes.add(new Node(2, 1L));    // Дочерний узел для 1
        nodes.add(new Node(3, 1L));    // Дочерний узел для 1
        nodes.add(new Node(4, 2L));    // Дочерний узел для 2
        nodes.add(new Node(5, 2L));    // Дочерний узел для 2
        nodes.add(new Node(6, 3L));    // Дочерний узел для 3

        return nodes;
    }

    public List<Node> someMethod() {
        List<Node> treeList = getList();

        for (Node node : treeList) {
            for (Node potentialChild : treeList){
                if (potentialChild.parentId == null) {
                    continue;
                }
                if (node.children == null) {
                    node.children = new ArrayList<>();
                }
                if (node.id == potentialChild.parentId) {
                    node.children.add(potentialChild);
                }
            }
        }

        return treeList;
    }

    public List<Node> someMethodOptimized() {
        List<Node> treeList = getList();
        Map<Long, Node> nodeMap = treeList.stream()
                .collect(Collectors.toMap(node -> node.id, node -> {
                    node.children = new ArrayList<>();
                    return node;
                }));

        for (Node node : treeList) {
            if (node.parentId != null) {
                Node parent = nodeMap.get(node.parentId);
                if (parent != null) {
                    if (parent.children == null) {
                        parent.children = new ArrayList<>();
                    }
                    parent.children.add(node);
                }
            }
        }

        return treeList;
    }

    public static void main(String[] args) {
        LC_FillChildrenInTreeNodeForTreeList fill = new LC_FillChildrenInTreeNodeForTreeList();
        List<Node> list = fill.someMethodOptimized();
        for (Node node : list) {
            System.out.println("Node ID: " + node.id + ", Children: " + node.children.size());
        }
    }
}
