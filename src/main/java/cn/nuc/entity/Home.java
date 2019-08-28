package cn.nuc.entity;

import java.util.List;

/**
 * 驴舍类
 * @author 黄华飞
 *
 */
public class Home {
	public Long homeId;
	public Long userId;
	public String useraccount;
	public float temperature;
	public float humidity;
	//改成光照sunlight
	public float illumination;
	public String dest1 ;
	public String dest2 ;
	public String PANID;
//	public String time;
	
	public List<Donkey> donkeyList;

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public final Long getHomeId() {
		return homeId;
	}
	public final void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
	public final Long getUserId() {
		return userId;
	}
	public final void setUserId(Long userId) {
		this.userId = userId;
	}
	public final List<Donkey> getDonkeyList() {
		return donkeyList;
	}
	public final void setDonkeyList(List<Donkey> donkeyList) {
		this.donkeyList = donkeyList;
	}

	public final float getTemperature() {
		return temperature;
	}
	public final void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public final float getHumidity() {
		return humidity;
	}
	public final void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public final float getillumination() {
		return illumination;
	}
	public final void setillumination(float illumination) {
		this.illumination = illumination;
	}
	public final String getDest1() {
		return dest1;
	}
	public final void setDest1(String dest1) {
		this.dest1 = dest1;
	}
	public final String getDest2() {
		return dest2;
	}
	public final void setDest2(String dest2) {
		this.dest2 = dest2;
	}
	public final String getPANID() {
		return PANID;
	}
	public final void setPANID(String pANID) {
		PANID = pANID;
	}
//	public final String getTime() {
//		return time;
//	}
//	public final void setTime(String time) {
//		this.time = time;
//	}
}
