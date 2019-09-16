package dao;

import entity.DonkeyHistory;

import java.util.List;

public interface DonkeyHistoryDao {
    List<DonkeyHistory> select(DonkeyHistory donkeyHistory);

    int insert(DonkeyHistory donkeyHistory);

    int update(DonkeyHistory donkeyHistory);

    DonkeyHistory selectById(Long id);

    int deleteByDonkeyId(Long homeId);

    int deleteById(Long id);
}
