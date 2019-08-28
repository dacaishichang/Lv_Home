package cn.nuc.entity;

public class DonkeyHistory {
    public Long donkeytimeId;
    public Long donkeyId;
    public String RFIDInfo;
    public Long size;
    public String time;

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
