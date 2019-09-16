package dao;

import entity.Home;

import java.util.List;

//增删改查

public interface HomeDao {

    List<Home> select(Home home) throws Exception;

    int insert(Home home) throws Exception;

    int update(Home home) throws Exception;

    Home selectById(Long id) throws Exception;

    int deleteByUserId(Long userId) throws Exception;

    int deleteById(Long id) throws Exception;
}
