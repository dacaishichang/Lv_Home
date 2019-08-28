package cn.nuc.entity;
/**
 * 驴的实体类
 * @author 黄华飞
 *
 */
public class Donkey {
	public Long donkeyId;
	public String RFIDInfo;
	public Long homeId;
	public String gender;
	public Long size;

	public String getRFIDInfo() {
		return RFIDInfo;
	}

	public void setRFIDInfo(String RFIDInfo) {
		this.RFIDInfo = RFIDInfo;
	}

	public final Long getSize() {
		return size;
	}
	public final void setSize(Long size) {
		this.size = size;
	}
	public final Long getDonkeyId() {
		return donkeyId;
	}
	public final void setDonkeyId(Long donkeyId) {
		this.donkeyId = donkeyId;
	}
	public final Long getHomeId() {
		return homeId;
	}
	public final void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
	public final String getGender() {
		return gender;
	}
	public final void setGender(String gender) {
		this.gender = gender;
	}

}
