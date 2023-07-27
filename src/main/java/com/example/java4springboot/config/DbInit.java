package com.example.java4springboot.config;

import com.example.java4springboot.entity.Tree;
import com.example.java4springboot.service.TreeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class DbInit {

    private final TreeService treeService;

    private Random random = new Random();

    public DbInit(final TreeService treeService) {
        this.treeService = treeService;
    }

    @PostConstruct
    private void postConstruct() {
        for (int i = 0; i < 10; i++) {
            final Tree tree = new Tree();
            tree.setAge(random.nextLong());
            tree.setName("Tree " + random.nextInt());
            tree.setIsGreen(random.nextBoolean());
            treeService.saveTree(tree);
        }

    }
}
