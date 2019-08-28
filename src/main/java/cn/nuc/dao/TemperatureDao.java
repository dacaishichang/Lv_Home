package cn.nuc.dao;

import cn.nuc.dto.TemperatureDto;
import cn.nuc.entity.HomeTemperatureHistory;

import java.util.List;

public interface TemperatureDao {
    List<HomeTemperatureHistory> select(TemperatureDto temperatureDto);

    int insert(HomeTemperatureHistory homeTemperatureHistory);

    int update(HomeTemperatureHistory homeTemperatureHistory);

    HomeTemperatureHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);

    int count(Long homeId);
}
