package dev.thoon.pshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    List<Category> findAll();

    Category findById(int id);

    Optional<Category> findByUrl(String url);
}
