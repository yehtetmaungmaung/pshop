package dev.thoon.pshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {
    
    Status getById(Integer id);

    Status findByName(String name);
}
