package entity;

//湿度
public class HomeHumidityHistory {
    private Long hometimeId;
    private Long homeId;
    private Long userId;
    private Float humidity;
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

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
