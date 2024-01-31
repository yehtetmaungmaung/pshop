package dev.thoon.pshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.thoon.pshop.entity.Account;
import dev.thoon.pshop.model.CurrentUser;
import dev.thoon.pshop.repository.AccountRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepo.findByName(username);

        if (account != null) {
            return new CurrentUser(account);
        }
        throw new UsernameNotFoundException("user not found");

    }
}
