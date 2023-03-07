package com.appl.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.appl.demo.model.User;

public interface IUserRepo extends CrudRepository<User, Integer> {


}
