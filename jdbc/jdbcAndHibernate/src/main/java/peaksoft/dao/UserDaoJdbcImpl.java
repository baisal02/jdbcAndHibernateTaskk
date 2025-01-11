package peaksoft.dao;

import peaksoft.jdbcconnection.JDBCconnection;
import peaksoft.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String str = "create table if not exists users(id serial primary key," +
                "name varchar," +
                "lastname varchar," +
                "age byte)";
        try(Statement statement = JDBCconnection.getConnection().createStatement()){
            statement.executeUpdate(str);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String str = "drop table if exists users";
        try(Statement statement = JDBCconnection.getConnection().createStatement()){
            statement.executeUpdate(str);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String str = "insert into users(name,lastname,age) values(?,?,?)";
        try(PreparedStatement preparedStatement = JDBCconnection.getConnection().prepareStatement(str)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
            String str = "delete from users where id=?";
            try(PreparedStatement preparedStatement = JDBCconnection.getConnection().prepareStatement(str)){
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
    }

    public List<User> getAllUsers() {
        String str = "select * from users";
        List<User> users = new ArrayList<>();
        try(Statement statement = JDBCconnection.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                users.add(new User(
                   resultSet.getLong("id"),
                   resultSet.getString("name"),
                   resultSet.getString("lastname"),
                   resultSet.getByte("age")
                ));
            }
            return users;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void cleanUsersTable() {
        String str = "truncate table users";
        try(Statement statement = JDBCconnection.getConnection().createStatement()){
            statement.executeUpdate(str);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}