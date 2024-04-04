package br.com.controle.user.controller.service;

import br.com.controle.user.controller.domain.model.Employee;
import br.com.controle.user.controller.domain.model.Role;
import br.com.controle.user.controller.domain.model.Status;
import br.com.controle.user.controller.domain.model.Usuario;
import br.com.controle.user.controller.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository repository;

    Employee employee;
    Usuario usuario;

    @BeforeEach
    public void setUp() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMIN);
        roles.add(Role.READ_EXCEL);

        usuario = new Usuario(1L,"Leonardo", "Bonifacio", "51152931024", "482476722");
        employee = new Employee(1L,"visanet", "Funcionarios", usuario, "LeonardoBonifacio#1234", "Desenvolvedor Java Junior I", roles, Status.ATIVO);
    }

    @Test
    void validateAtributesOfEmployee() {
       repository.save(employee);

       //Employee id must not be null
        assertThat(employee.getId()).isNotNull();

        //User id must not be null
        assertThat(employee.getUser().getNuCPF()).isNotNull();
    }

    @Test
    void getAllEmployees() {
        repository.save(employee);

        assertThat(repository.findAll()).isNotNull();
    }
}
