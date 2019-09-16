package entity;

//温度
public class HomeTemperatureHistory {
    private Long hometimeId;
    private Long homeId;
    private Long userId;
    private Float temperature;
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
