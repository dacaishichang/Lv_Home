package cn.nuc.dao;

import cn.nuc.dto.IlluminationDto;
import cn.nuc.entity.HomeIlluminationHistory;

import java.util.List;

public interface IlluminationDao {
    List<HomeIlluminationHistory> select(IlluminationDto illuminationDto);

    int insert(HomeIlluminationHistory homeIlluminationHistory);

    int update(HomeIlluminationHistory homeIlluminationHistory);

    HomeIlluminationHistory selectById(Long id);

    int deleteByHomeId(Long homeId);

    int deleteById(Long id);

    int count(Long homeId);
}
