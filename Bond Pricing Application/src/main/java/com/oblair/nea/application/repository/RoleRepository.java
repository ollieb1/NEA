package com.oblair.nea.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oblair.nea.application.domain.Role;
import com.oblair.nea.application.domain.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByName(RoleName roleName);
}