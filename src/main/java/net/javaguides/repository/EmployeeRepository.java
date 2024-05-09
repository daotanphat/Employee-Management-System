package net.javaguides.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
