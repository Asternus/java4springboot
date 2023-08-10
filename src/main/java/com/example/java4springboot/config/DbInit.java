package com.example.java4springboot.config;

import com.example.java4springboot.entity.Role;
import com.example.java4springboot.entity.Tree;
import com.example.java4springboot.entity.User;
import com.example.java4springboot.service.TreeService;
import com.example.java4springboot.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.Set;

@Component
public class DbInit {

    private final TreeService treeService;

    private final UserService userService;

    private Random random = new Random();

    public DbInit(final TreeService treeService, final UserService userService) {
        this.treeService = treeService;
        this.userService = userService;
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

        final User user = new User();
        user.setEmail("user@gmail.com");
        user.setUsername("cat");
        user.setPassword("cat");

        userService.addUser(user);
    }
}
