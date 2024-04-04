package br.com.controle.user.controller.service.impl;

import br.com.controle.user.controller.domain.model.Employee;
import br.com.controle.user.controller.domain.repository.EmployeeRepository;
import br.com.controle.user.controller.service.EmployeeService;
import br.com.controle.user.controller.service.exception.BusinessException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static java.util.Optional.ofNullable;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee findByLogin(Long aLong) {
        return null;
    }

    @Transactional
    @Override
    public Employee create(Employee employee) {
        ofNullable(employee).orElseThrow(() -> new BusinessException("Employee must not be null."));
        ofNullable(employee.getUser()).orElseThrow(() -> new BusinessException("User must not be null"));
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public String createLogin(Employee employee) {
        String givenName = employee.getUser().getGivenName();
        String surname = employee.getUser().getSurname();
        return givenName + surname + "#" + new Random().nextInt(1000);
    }
}
