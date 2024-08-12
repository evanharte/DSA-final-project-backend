package com.keyin.finalProject.BinarySearchTree;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BinarySearchTreeController {

    private final BinarySearchTreeService service;

    public BinarySearchTreeController(BinarySearchTreeService service) {
        this.service = service;
    }

    @PostMapping("/create-tree")
    public ResponseEntity<?> createTree(@RequestBody List<Integer> numbers) {
        TreeNode tree = service.createTree(numbers);
        return ResponseEntity.ok(tree);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<BinarySearchTree>> getPreviousTrees() {
        List<BinarySearchTree> trees = service.getAllTrees();
        return ResponseEntity.ok(trees);
    }
}
