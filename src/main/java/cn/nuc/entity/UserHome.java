package cn.nuc.entity;

/**
 * 关联类
 * @author 黄华飞
 *
 */
public class UserHome {
	public Long userId;
	public Long homeId;
	public final Long getUserId() {
		return userId;
	}
	public final void setUserId(Long userId) {
		this.userId = userId;
	}
	public final Long getHomeId() {
		return homeId;
	}
	public final void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
}
