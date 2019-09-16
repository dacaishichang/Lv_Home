package entity;

public class Home {
    private Long homeId;
    private Long userId;
    private String useraccount;
    private Float temperature;
    private Float humidity;
    //改成光照sunlight
    private Float illumination;
    private String dest1 ;
    private String dest2 ;
    private String PANID;
    private String time;

//    private List<Donkey> donkeyList;

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
//    public final List<Donkey> getDonkeyList() {
//        return donkeyList;
//    }
//    public final void setDonkeyList(List<Donkey> donkeyList) {
//        this.donkeyList = donkeyList;
//    }

    public final Float getTemperature() {
        return temperature;
    }
    public final void setTemperature(Float temperature) {
        this.temperature = temperature;
    }
    public final Float getHumidity() {
        return humidity;
    }
    public final void setHumidity(Float humidity) {
        this.humidity = humidity;
    }
    public final Float getIllumination() {
        return illumination;
    }
    public final void setIllumination(Float illumination) {
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
    public final String getTime() {
        return time;
    }
    public final void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "Home:"
                +homeId+","
                +userId+","
                +useraccount+","+
                temperature+","+
                humidity+","+
                illumination+","+
                dest1+","+
                dest2+","+
                time;
    }
}