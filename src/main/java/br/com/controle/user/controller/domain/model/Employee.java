package br.com.controle.user.controller.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "TB_EMPLOYEE")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tree;

    @Column(nullable = false)
    private String container;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario user;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String position;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
