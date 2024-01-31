package dev.thoon.pshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findByPhone(String phone);
}
