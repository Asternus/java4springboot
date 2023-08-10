package com.example.java4springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name can not be Blank")
    private String name;

    private long age;

    private Boolean isGreen;

    @OneToOne
    private User user;

    public Tree() {
    }
}
