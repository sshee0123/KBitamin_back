package com.kb1.springbootback.repository.user;

import java.util.Optional;

import com.kb1.springbootback.model.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsById(String id);

	Boolean existsByEmail(String email);

	Optional<User> findById(String id);

	User findAllById(String id);

}