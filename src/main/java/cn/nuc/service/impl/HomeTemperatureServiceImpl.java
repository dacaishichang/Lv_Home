package cn.nuc.service.impl;

import cn.nuc.dao.TemperatureDao;
import cn.nuc.dto.IlluminationDto;
import cn.nuc.dto.TemperatureDto;
import cn.nuc.entity.HomeIlluminationHistory;
import cn.nuc.entity.HomeTemperatureHistory;
import cn.nuc.service.HomeTemperatureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeTemperatureServiceImpl implements HomeTemperatureService {

    @Autowired
    private TemperatureDao temperatureDao;

    @Override
    public boolean add(TemperatureDto temperatureDto) {
        return false;
    }

    @Override
    public boolean remove(Long hometimeId) {
        return false;
    }

    @Override
    public TemperatureDto getById(Long hometimeId) {
        return null;
    }

    @Override
    public boolean modify(TemperatureDto temperatureDto) {
        return false;
    }

    @Override
    public List<TemperatureDto> getByHomeId(Long homeId) {
        List<TemperatureDto> result = new ArrayList<>();
        TemperatureDto temp = new TemperatureDto();
        temp.setHomeId(homeId);
        List<HomeTemperatureHistory> homeTemperatureHistoryList = temperatureDao.select(temp);
        for (HomeTemperatureHistory homeTemperatureHistory : homeTemperatureHistoryList) {
            TemperatureDto temperatureDto = new TemperatureDto();
            result.add(temperatureDto);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeTemperatureHistory, temperatureDto);
            temperatureDto.setpId(0);
        }
        return result;
    }

    @Override
    public List<TemperatureDto> getList(TemperatureDto temperatureDto) {
        List<TemperatureDto> result = new ArrayList<>();
        List<HomeTemperatureHistory> homeTemperatureHistoryList = temperatureDao.select(temperatureDto);
        for (HomeTemperatureHistory homeTemperatureHistory : homeTemperatureHistoryList) {
            TemperatureDto temperatureDto_ = new TemperatureDto();
            result.add(temperatureDto_);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(homeTemperatureHistory, temperatureDto_);
            temperatureDto.setpId(0);
        }
        return result;
    }

    @Override
    public int selectCount(Long homeId) {
        return temperatureDao.count(homeId);
    }


}
