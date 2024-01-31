package dev.thoon.pshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.thoon.pshop.entity.Account;
import dev.thoon.pshop.entity.Role;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findByName(String name);

    List<Account> findAllByRole(Role role);

    List<Account> findAll();

    Account findByEmail(String email);
}
