package br.com.controle.user.controller.controllers;


import br.com.controle.user.controller.controllers.dto.EmployeeDTO;
import br.com.controle.user.controller.domain.model.Employee;
import br.com.controle.user.controller.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Tag(name = "Employee's Controller", description = "RESTful API for managing employee's.")
public record EmployeeController(EmployeeService employeeService) {

    @GetMapping
    @Operation(summary = "Get all employee's", description = "Retrieve a list of all registered employee's")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operation successful")})
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        var employee = employeeService.findAllEmployee();
        var employeeDto = employee.stream().map(EmployeeDTO::new).toList();
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping("/create/employee")
    @Operation(summary = "Create an employee's", description = "Create a new employee and return the created employee's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee's created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid employee data provided")
    })
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.create(employeeDTO.toModel());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).body(new EmployeeDTO(employee));
    }
}
