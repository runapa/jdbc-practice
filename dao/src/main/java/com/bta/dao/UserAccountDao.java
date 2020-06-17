package com.bta.dao;

import com.bta.model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.bta.dao.AbstractDao.getConnection;

public class UserAccountDao implements Dao {
    @Override
    public void save(UserAccount userAccount) {
        final String sql = "INSERT INTO user_account (id, username, password, email, tax_number, first_name, last_name)" +
                " values (nextval('user_account_seq'), ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, userAccount.getUsername());
            statement.setString(2, userAccount.getPassword());
            statement.setString(3, userAccount.getEmail());
            statement.setLong(4, userAccount.getTaxNumber());
            statement.setString(5, userAccount.getFirstName());
            statement.setString(6, userAccount.getLastName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserAccount> findAll() {
        List<UserAccount> userAccounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_account");
        ){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                UserAccount userAccount = new UserAccount(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("tax_number"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                userAccounts.add(userAccount);
            }
        } catch (SQLException e) {
            System.out.println("Error in the Connection establishment");
            e.printStackTrace();
        }
        return userAccounts;
    }

    @Override
    public UserAccount findOne(Long id) {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_account WHERE id = ?");
        ){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return  new UserAccount(
                        id,
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("tax_number"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error in the Connection establishment");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(UserAccount userAccount) {
        final String sql = "UPDATE user_account SET " +
                "username = ?, password = ?, email = ?, tax_number = ?, first_name = ?, last_name = ?" +
                " WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, userAccount.getUsername());
            statement.setString(2, userAccount.getPassword());
            statement.setString(3, userAccount.getEmail());
            statement.setLong(4, userAccount.getTaxNumber());
            statement.setString(5, userAccount.getFirstName());
            statement.setString(6, userAccount.getLastName());
            statement.setLong(7, userAccount.getId());

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(Long id) {
        final String sql = "DELETE FROM user_account WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
