package dao;

import entity.Donkey;

import java.util.List;

//增删改查

public interface DonkeyDao {
    List<Donkey> select(Donkey donkey) throws Exception;

    int insert(Donkey donkey) throws Exception;

    int update(Donkey donkey) throws Exception;

    Donkey selectById(Long id) throws Exception;

    int selectByDonkeyId(Long donkeyId) throws Exception;

    int deleteById(Long id) throws Exception;
}

