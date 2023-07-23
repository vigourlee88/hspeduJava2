package com.itheima.service;

import java.util.List;

import com.itheima.domain.Account;

public interface AccountService {
	void save(Account account);
    void update(Account account);
    void delete(Integer id);
    List<Account> findAll();
    Account findById(Integer id);

}
