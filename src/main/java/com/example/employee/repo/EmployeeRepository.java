package com.example.employee.repo;

import com.example.employee.model.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeModel,String> {

    EmployeeModel findByUserName(String userName);

    EmployeeModel deleteByUserName(String userName);
}
