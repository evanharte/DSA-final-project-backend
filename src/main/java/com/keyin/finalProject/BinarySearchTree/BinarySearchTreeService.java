package com.keyin.finalProject.BinarySearchTree;

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
        return root; // Return the tree structure as a TreeNode object
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
}
