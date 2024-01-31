package dev.thoon.pshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Subcategory;

public interface SubCategoryRepo extends JpaRepository<Subcategory, Long> {
    
    List<Subcategory> findAll();

    Subcategory findByName(String subcategory);

    Subcategory findByUrl(String subcategory);
}
