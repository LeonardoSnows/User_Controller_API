package br.com.controle.user.controller.domain.repository;

import br.com.controle.user.controller.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByLogin(String login);
}
