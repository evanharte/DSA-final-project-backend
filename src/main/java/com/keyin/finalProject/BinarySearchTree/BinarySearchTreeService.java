package com.keyin.finalProject.BinarySearchTree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinarySearchTreeService {

    private final BinarySearchTreeRepository repository;

    public BinarySearchTreeService(BinarySearchTreeRepository repository) {
        this.repository = repository;
    }

    public TreeNode createTree(List<Integer> numbers) {
        TreeNode root = null;
        for (Integer number : numbers) {
            root = insert(root, number);
        }

        String treeJson = convertTreeToJson(root);

        BinarySearchTree treeEntity = new BinarySearchTree();
        treeEntity.setInputNumbers(numbers);
        treeEntity.setTreeStructure(treeJson);
        repository.save(treeEntity);

        return root;
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public List<BinarySearchTree> getAllTrees() {
        return repository.findAll();
    }

    private String convertTreeToJson(TreeNode root) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
