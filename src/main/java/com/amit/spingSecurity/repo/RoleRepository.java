package com.amit.spingSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.spingSecurity.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

}
