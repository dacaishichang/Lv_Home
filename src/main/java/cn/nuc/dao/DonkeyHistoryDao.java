package cn.nuc.dao;

import cn.nuc.dto.DonkeyDto;
import cn.nuc.dto.DonkeyHistoryDto;
import cn.nuc.entity.DonkeyHistory;

import java.util.List;

public interface DonkeyHistoryDao {

    List<DonkeyHistory> select(DonkeyHistoryDto donkeyHistoryDto);

    int insert(DonkeyHistory donkeyHistory);

    int update(DonkeyHistory donkeyHistory);

    DonkeyHistory selectById(Long id);

    int deleteByDonkeyId(Long homeId);

    int deleteById(Long id);

    int count();
}
