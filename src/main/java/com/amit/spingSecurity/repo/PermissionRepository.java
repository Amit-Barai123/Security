package com.amit.spingSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.spingSecurity.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
