package dao;

import entity.HomeHumidityHistory;

import java.util.List;

public interface HomeHumidityHistoryDao {
    List<HomeHumidityHistory> select(HomeHumidityHistory homeHumidityHistory);

    int insert(HomeHumidityHistory homeHumidityHistory);

    int update(HomeHumidityHistory homeHumidityHistory);

    HomeHumidityHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);
}
