package cn.nuc.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.nuc.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nuc.dao.DonkeyDao;
import cn.nuc.dto.DonkeyDto;
import cn.nuc.dto.DonkeyDto;
import cn.nuc.entity.Donkey;
import cn.nuc.entity.Donkey;
import cn.nuc.service.DonkeyService;


@Service
public class DonkeyServiceImpl implements DonkeyService{

	@Autowired
	private DonkeyDao donkeyDao;
	
	
	@Override
	public boolean add(DonkeyDto donkeyDto) {
		Donkey donkey = new Donkey();
		BeanUtils.copyProperties(donkeyDto, donkey);
		System.out.println(donkey);
		if(donkey.getRFIDInfo()==null||donkey.getRFIDInfo().equals("")){
			donkey.setRFIDInfo("None");
		}
		return donkeyDao.insert(donkey) == 1;
	}

	/**
	 * 删除驴舍
	 */
	@Override
	public boolean remove(Long donkeyid) {
		return donkeyDao.deleteById(donkeyid) == 1;
	}

	/**
	 * 根据id查找驴的列表
	 */
	@Override
	public DonkeyDto getById(Long donkeyId) {
		DonkeyDto donkeyDto = new DonkeyDto();
		Donkey donkey = donkeyDao.selectById(donkeyId);
		BeanUtils.copyProperties(donkey, donkeyDto);
		return donkeyDto;
	}

	/**
	 * 根据驴舍查找驴的列表
	 */
	@Override
	public List<DonkeyDto> getByDonkeyId(Long donkeyId) {
		List<DonkeyDto> result = new ArrayList<>();
		List<Donkey> donkeyList = donkeyDao.select(new Donkey());
		for (Donkey donkey : donkeyList) {
			DonkeyDto donkeyDto = new DonkeyDto();
			result.add(donkeyDto);
			//字段赋值，常用于类赋值
			BeanUtils.copyProperties(donkey, donkeyDto);
			donkeyDto.setpId(0);
		}
		return result;
	}



	@Override
	public List<DonkeyDto> getList(DonkeyDto donkeyDto) {
		List<DonkeyDto> result = new ArrayList<>();
		List<Donkey> donkeyList = donkeyDao.select(donkeyDto);
		for (Donkey donkey : donkeyList) {
			DonkeyDto donkeyDto_ = new DonkeyDto();
			result.add(donkeyDto_);
			//字段赋值，常用于类赋值
			BeanUtils.copyProperties(donkey, donkeyDto_);
			donkeyDto.setpId(0);
		}
		return result;
	}

	@Override
	public boolean modify(DonkeyDto donkeyDto) {
		Donkey donkey=new Donkey();
		BeanUtils.copyProperties(donkeyDto, donkey);
		return donkeyDao.update(donkey) == 1;
	}

	@Override
	public int selectCount() {
		return donkeyDao.count();
	}

	@Override
	public boolean validate(DonkeyDto donkeyDto) {
		List<Donkey> list = donkeyDao.validate(donkeyDto);
		if(list.size()==1){
			return true;
		}
		return false;
	}
}
