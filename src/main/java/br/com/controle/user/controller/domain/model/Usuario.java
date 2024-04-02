package br.com.controle.user.controller.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity(name = "TB_USUARIOS")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255, nullable = false)
    private String givenName;

    @Column(length = 255, nullable = false)
    private String surname;

    @CPF
    @Column(unique = true, length = 11, nullable = false)
    private String nuCPF;

    @Column(length = 255, nullable = false)
    private String nuRG;

}
