package dev.thoon.pshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.SpecCategory;

public interface SpecCategoryRepo extends JpaRepository<SpecCategory, Integer> {
    
    List<SpecCategory> findAll();

    SpecCategory findByName(String specCategory);
}
