package br.com.controle.user.controller.service;

import br.com.controle.user.controller.domain.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService extends EmployeeCrudService<Long, Employee> {}
