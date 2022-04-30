package com.kb1.springbootback.repository.user;

import com.kb1.springbootback.model.user.ERole;
import com.kb1.springbootback.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
