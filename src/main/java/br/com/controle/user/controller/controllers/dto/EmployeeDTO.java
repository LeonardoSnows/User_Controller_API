package br.com.controle.user.controller.controllers.dto;

import br.com.controle.user.controller.domain.model.Employee;
import br.com.controle.user.controller.domain.model.Role;
import br.com.controle.user.controller.domain.model.Status;
import br.com.controle.user.controller.service.EmployeeService;
import br.com.controle.user.controller.service.impl.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Optional.ofNullable;

public record EmployeeDTO(Long id, String tree, String container, UsuarioDTO user, String position) {

    public EmployeeDTO(Employee model) {
        this(
                model.getId(),
                model.getTree(),
                model.getContainer(),
                ofNullable(model.getUser()).map(UsuarioDTO::new).orElse(null),
                model.getPosition()
        );
    }

    public Employee toModel() {
        Employee model = new Employee();
        EmployeeService employeeService = new EmployeeServiceImpl();

        model.setTree(this.tree);
        model.setContainer(this.container);
        model.setUser(ofNullable(this.user).map(UsuarioDTO::toModel).orElse(null));
        model.setLogin(employeeService.createLogin(model));
        model.setRoles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.READ_EXCEL)));
        model.setPosition(this.position);
        model.setStatus(Status.ATIVO);

        return model;
    }

}
