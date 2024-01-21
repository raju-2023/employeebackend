package com.employee.service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

private final EmployeeRepository employeeRepository;

public Employee postEmployee(Employee employee){
    return employeeRepository.save(employee);
}
public List<Employee> getAllEmployee(){

    return employeeRepository.findAll();
}

public void deleteEmployee(Long id){
    if(!employeeRepository.existsById(id))
    {
        throw new EntityNotFoundException("Employee with ID " + id + " not found");
    }

    employeeRepository.deleteById(id);
}

public Employee getEmployeeById(Long id){
    return employeeRepository.findById(id).orElse(null);
}

}
