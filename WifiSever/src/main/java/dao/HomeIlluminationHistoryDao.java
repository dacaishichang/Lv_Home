package dao;

import entity.HomeIlluminationHistory;

import java.util.List;

public interface HomeIlluminationHistoryDao {
    List<HomeIlluminationHistory> select(HomeIlluminationHistory homeIlluminationHistory);

    int insert(HomeIlluminationHistory homeIlluminationHistory);

    int update(HomeIlluminationHistory homeIlluminationHistory);

    HomeIlluminationHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);
}
