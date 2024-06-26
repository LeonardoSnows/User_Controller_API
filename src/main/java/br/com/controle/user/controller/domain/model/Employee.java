package br.com.controle.user.controller.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "TB_EMPLOYEE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Employee(String tree, String container, Usuario user, String login, String position, Set<Role> roles, Status status) {
        this.tree = tree;
        this.container = container;
        this.user = user;
        this.login = login;
        this.position = position;
        this.roles = roles;
        this.status = status;
    }
}
