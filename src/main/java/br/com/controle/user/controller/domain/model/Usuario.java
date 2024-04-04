package br.com.controle.user.controller.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity(name = "TB_USUARIOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String givenName;

    @Column(length = 255, nullable = false)
    private String surname;

    @CPF
    @Column(unique = true, length = 11, nullable = false)
    private String nuCPF;

    @Column(length = 255, nullable = false)
    private String nuRG;

    public Usuario(String givenName, String surname, String nuCPF, String nuRG) {
        this.givenName = givenName;
        this.surname = surname;
        this.nuCPF = nuCPF;
        this.nuRG = nuRG;
    }
}
