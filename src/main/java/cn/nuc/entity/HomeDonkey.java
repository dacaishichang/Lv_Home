package cn.nuc.entity;


/**
 * 关联类
 * @author 黄华飞
 *
 */
public class HomeDonkey {
	public Long homeId;
	public Long donkeyId;
	public final Long getHomeId() {
		return homeId;
	}
	public final void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
	public final Long getDonkeyId() {
		return donkeyId;
	}
	public final void setDonkeyId(Long donkeyId) {
		this.donkeyId = donkeyId;
	}
}
