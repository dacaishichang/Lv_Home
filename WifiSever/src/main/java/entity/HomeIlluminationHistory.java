package entity;

//光照
public class HomeIlluminationHistory {
    private Long hometimeId;
    private Long homeId;
    private Long userId;
    private Float illumination;
    private String time;

    public Long getHometimeId() {
        return hometimeId;
    }

    public void setHometimeId(Long hometimeId) {
        this.hometimeId = hometimeId;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getIllumination() {
        return illumination;
    }

    public void setIllumination(Float illumination) {
        this.illumination = illumination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
