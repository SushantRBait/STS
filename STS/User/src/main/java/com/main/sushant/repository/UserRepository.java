package com.main.sushant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.sushant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(Integer userId);

}