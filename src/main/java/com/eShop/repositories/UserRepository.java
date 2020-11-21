package com.eShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eShop.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
