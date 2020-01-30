package com.angular.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    List<User> findByEmail(String email);
}