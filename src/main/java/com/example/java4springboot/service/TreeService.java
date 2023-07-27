package com.example.java4springboot.service;

import com.example.java4springboot.entity.Tree;
import com.example.java4springboot.repo.TreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    private TreeRepo treeRepo;

    @Autowired
    public TreeService(TreeRepo treeRepo) {
        this.treeRepo = treeRepo;
    }

    public void saveTree(final Tree tree) {
        treeRepo.save(tree);
    }

    public List<Tree> getTrees() {
        return treeRepo.findAll();
    }

}