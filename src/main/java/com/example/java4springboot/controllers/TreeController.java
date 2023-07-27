package com.example.java4springboot.controllers;

import com.example.java4springboot.entity.Tree;
import com.example.java4springboot.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TreeController {

    private TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping()
    public String getHome(Model model) {
        final List<Tree> trees = treeService.getTrees();
        model.addAttribute("trees", trees);
        return "index";
    }

    @GetMapping("/trees")
    public String getBooks(Model model) {
        final List<Tree> trees = treeService.getTrees();
        model.addAttribute("trees", trees);
        return "index";
    }

    @GetMapping("/tree")
    public String formForTree(Model model) {
        return "treeserv";
    }

    @PostMapping("/add")
    public String addBook(Tree tree) {
        tree.setIsGreen(true);
        treeService.saveTree(tree);
        return "redirect:/";
    }

}
