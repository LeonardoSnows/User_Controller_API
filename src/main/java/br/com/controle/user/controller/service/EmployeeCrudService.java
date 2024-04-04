package br.com.controle.user.controller.service;

import br.com.controle.user.controller.domain.model.Employee;

import java.util.List;


public interface EmployeeCrudService<ID, T> {
    T findByLogin(ID id);

    T create(T userToCreate);

    List<T> findAllEmployee();

    String createLogin(Employee employee);
}
