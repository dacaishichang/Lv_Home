package entity;

public class DonkeyHistory {
    private Long donkeytimeId;
    private Long donkeyId;
    private String RFIDInfo;
    private Long size;
    private String time;

    public Long getDonkeytimeId() {
        return donkeytimeId;
    }

    public void setDonkeytimeId(Long donkeytimeId) {
        this.donkeytimeId = donkeytimeId;
    }

    public Long getDonkeyId() {
        return donkeyId;
    }

    public void setDonkeyId(Long donkeyId) {
        this.donkeyId = donkeyId;
    }

    public String getRFIDInfo() {
        return RFIDInfo;
    }

    public void setRFIDInfo(String RFIDInfo) {
        this.RFIDInfo = RFIDInfo;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
