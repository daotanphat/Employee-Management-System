package net.javaguides.service;

import java.util.List;
import net.javaguides.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}
