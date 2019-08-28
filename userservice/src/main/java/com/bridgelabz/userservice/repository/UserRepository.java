package com.bridgelabz.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.userservice.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmailid(String emailid);

	public Optional<User> findById(Long id);
}
