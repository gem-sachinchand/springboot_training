package com.example.employee.repository;

import com.example.employee.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    Boolean existsByUserName(String userName);

    @Query(value="{userName:?0}")
    UserModel findByUserName(String userName);

}
