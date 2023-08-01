package com.example.java4springboot.controllers;

import com.example.java4springboot.entity.Tree;
import com.example.java4springboot.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/trees/{id}")
    public String getBooks(Model model, @PathVariable Long id) {
        final Optional<Tree> treeById = treeService.getTreeById(id);
        final Tree tree = treeById.orElse(null);
        model.addAttribute("tree", tree);
        model.addAttribute("id", id);
        return "tree";
    }

    @GetMapping("/tree")
    public String formForTree(Model model) {
        return "treeserv";
    }

    @PostMapping("/add")
    public String addBook(@Valid Tree tree) {
        tree.setIsGreen(true);
        treeService.saveTree(tree);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String postEditTree(@PathVariable Long id,
                               Model model,
                               Tree tree) {
        final Optional<Tree> treeById = treeService.getTreeById(id);

        if (treeById.isEmpty()) {
            throw new IllegalStateException();
        }

        final Tree tree1 = treeById.get();
        tree1.setAge(tree.getAge());
        tree1.setName(tree.getName());

        treeService.saveTree(tree1);

        return "redirect:/";
    }

    @GetMapping("/trees/delete/{id}")
    public String deleteTree(Model model, @PathVariable Long id) {
        final Optional<Tree> treeById = treeService.getTreeById(id);
        final Tree tree = treeById.orElse(null);
        treeService.deleteTree(tree);
        return "redirect:/";
    }

}
