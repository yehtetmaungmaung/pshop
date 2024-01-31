package dev.thoon.pshop.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.thoon.pshop.entity.Account;
import dev.thoon.pshop.entity.Role;
import dev.thoon.pshop.repository.AccountRepo;
import dev.thoon.pshop.repository.RoleRepo;
import dev.thoon.pshop.services.AccountService;
import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;

    public AccountServiceImpl(AccountRepo accountRepo, RoleRepo roleRepo) {
        this.accountRepo = accountRepo;
        this.roleRepo = roleRepo;
    }


    @Override
    public Account findAccountByLogin(String login) {
        return accountRepo.findByName(login);
    }

    @Transactional
    @Override
    public Account createAccount(Account account) {
        Role role =  roleRepo.findByName(account.getRole().getName());
        account.setRole(role);
        return accountRepo.save(account);
    }
}
