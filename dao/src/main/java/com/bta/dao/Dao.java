package com.bta.dao;

import com.bta.model.UserAccount;

import java.util.List;

//For CRUD operations
public interface Dao {
    void save(UserAccount userAccount);

    List<UserAccount> findAll();

    UserAccount findOne(Long id);

    int update(UserAccount userAccount);

    int delete(Long id);
}
