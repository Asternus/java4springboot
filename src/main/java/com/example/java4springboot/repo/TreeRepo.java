package com.example.java4springboot.repo;

import com.example.java4springboot.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepo extends JpaRepository<Tree, Long> {
}
