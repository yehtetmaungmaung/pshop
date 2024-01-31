package dev.thoon.pshop.services;

import dev.thoon.pshop.entity.Account;

public interface AccountService {
    
    Account findAccountByLogin(String login);

    Account createAccount(Account account);
}
