package dev.thoon.pshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.thoon.pshop.entity.Role;

public interface RoleRepo extends PagingAndSortingRepository<Role, Integer> {
    
    Role findByName(String name);
}
