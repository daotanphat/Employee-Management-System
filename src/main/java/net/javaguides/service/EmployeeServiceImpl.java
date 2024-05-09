package net.javaguides.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.exception.ResourceNotFoundException;
import net.javaguides.model.Employee;
import net.javaguides.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    static Employee unwrappedEmployee(Optional<Employee> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new ResourceNotFoundException("Not find");
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = unwrappedEmployee(employeeRepository.findById(id), id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = unwrappedEmployee(employeeRepository.findById(id), id);
        employeeRepository.delete(employee);
    }
}
