package dao;

import entity.HomeTemperatureHistory;

import java.util.List;

public interface HomeTemperatureHistoryDao {
    List<HomeTemperatureHistory> select(HomeTemperatureHistory homeTemperatureHistory);

    int insert(HomeTemperatureHistory homeTemperatureHistory);

    int update(HomeTemperatureHistory homeTemperatureHistory);

    HomeTemperatureHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);
}
