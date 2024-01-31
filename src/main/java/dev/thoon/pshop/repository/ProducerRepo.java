package dev.thoon.pshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Producer;

public interface ProducerRepo extends JpaRepository<Producer, Long>{
    List<Producer> findAll();

    Producer findByName(String name);
}
