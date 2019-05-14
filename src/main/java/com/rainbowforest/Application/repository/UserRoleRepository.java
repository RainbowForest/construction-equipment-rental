package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rainbowforest.Application.model.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
}
