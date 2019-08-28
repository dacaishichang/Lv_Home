package cn.nuc.service.impl;

import cn.nuc.dao.DonkeyDao;
import cn.nuc.dao.DonkeyHistoryDao;
import cn.nuc.dto.DonkeyDto;
import cn.nuc.dto.DonkeyHistoryDto;
import cn.nuc.dto.UserDto;
import cn.nuc.entity.DonkeyHistory;
import cn.nuc.entity.User;
import cn.nuc.service.DonkeyHistoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonkeyHistoryServiceImpl  implements DonkeyHistoryService {

    @Autowired
    private DonkeyHistoryDao donkeyHistoryDao;

    @Override
    public boolean add(DonkeyHistoryDto donkeyHistoryDto) {
        return false;
    }

    @Override
    public boolean remove(Long hometimeId) {
        return false;
    }

    @Override
    public DonkeyHistoryDto getById(Long hometimeId) {
        return null;
    }

    @Override
    public boolean modify(DonkeyHistoryDto donkeyHistoryDto) {
        return false;
    }

    @Override
    public List<DonkeyHistoryDto> getByDonkeyId(Long donkeyId) {
        List<DonkeyHistoryDto> result = new ArrayList<>();
        DonkeyHistoryDto temp = new DonkeyHistoryDto();
        temp.setDonkeyId(donkeyId);
        List<DonkeyHistory> donkeyHistoryList = donkeyHistoryDao.select(temp);
        for (DonkeyHistory donkeyHistory : donkeyHistoryList) {
            DonkeyHistoryDto donkeyHistoryDto = new DonkeyHistoryDto();
            result.add(donkeyHistoryDto);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(donkeyHistory, donkeyHistoryDto);
            donkeyHistoryDto.setpId(0);
        }
        return result;

    }

    @Override
    public List<DonkeyHistoryDto> getList(DonkeyHistoryDto donkeyHistoryDto) {
        List<DonkeyHistoryDto> result = new ArrayList<>();
        List<DonkeyHistory> donkeyHistoryList = donkeyHistoryDao.select(donkeyHistoryDto);
        for (DonkeyHistory donkeyHistory : donkeyHistoryList) {
            DonkeyHistoryDto donkeyHistoryDto_ = new DonkeyHistoryDto();
            result.add(donkeyHistoryDto_);
            //字段赋值，常用于类赋值
            BeanUtils.copyProperties(donkeyHistory, donkeyHistoryDto_);
            donkeyHistoryDto.setpId(0);
        }
        return result;
    }

    @Override
    public int selectCount() {
        return donkeyHistoryDao.count();
    }
}
