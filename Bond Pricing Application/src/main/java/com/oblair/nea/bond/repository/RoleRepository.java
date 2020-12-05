package com.oblair.nea.bond.repository;

import com.oblair.nea.bond.domain.Role;
import com.oblair.nea.bond.domain.RoleName;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByName(RoleName roleName);
}