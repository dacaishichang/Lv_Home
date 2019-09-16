package entity;

public class Donkey {
    private Long donkeyId;
    private String RFIDInfo;
    private Long homeId;
    private String gender;
    private Long size;

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

    @Override
    public String toString() {
        return "["+donkeyId+","+RFIDInfo+","+homeId+","+gender+","+size+"]";
    }
}
