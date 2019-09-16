package dao;

import entity.User;

import java.util.List;

//增删改查

public interface UserDao {

    List<User> select(User user) throws Exception;;

    Long insert(User user) throws Exception;;

    User selectById(Long id) throws Exception;;

    Long update(User user) throws Exception;;

    Long delete(Long id) throws Exception;;
}
