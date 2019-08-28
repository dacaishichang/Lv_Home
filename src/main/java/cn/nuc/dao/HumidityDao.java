package cn.nuc.dao;

import cn.nuc.dto.HumidityDto;
import cn.nuc.entity.HomeHumidityHistory;

import java.util.List;

public interface HumidityDao {
    List<HomeHumidityHistory> select(HumidityDto humidityDto);

    int insert(HomeHumidityHistory homeHumidityHistory);

    int update(HomeHumidityHistory homeHumidityHistory);

    HomeHumidityHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);

    int count(Long homeId);
}
