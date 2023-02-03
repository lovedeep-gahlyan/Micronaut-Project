package com.lovedeep.task.repo;

import com.lovedeep.task.model.Employee;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.jpa.repository.JpaRepository;
import jakarta.inject.Singleton;

@Singleton
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
