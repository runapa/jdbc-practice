package com.bta;

import com.bta.dao.Dao;
import com.bta.dao.UserAccountDao;
import com.bta.model.UserAccount;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Dao userAccountDao = new UserAccountDao();
        //final UserAccount userAccount = new UserAccount("Ilja", "password", "ilja@gmail.com", 1001L, "Ilja", "Kirillov");
        //userAccountDao.save(userAccount);
//        userAccount.setId(1);
//        userAccount.setFirstName("Kirill");
//        userAccountDao.update(userAccount);
//
//        UserAccount user1 = userAccountDao.findOne(1L);
        userAccountDao.delete(1L);
        List<UserAccount> users = userAccountDao.findAll();
        System.out.println(users);
    }
}