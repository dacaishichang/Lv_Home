package entity;

public class JsonData {
    private String nwkAddr;
    private String parAddr;
    private String macAddr;
    private funcData funcList;

    public String getNwkAddr() {
        return nwkAddr;
    }

    public void setNwkAddr(String nwkAddr) {
        this.nwkAddr = nwkAddr;
    }

    public String getParAddr() {
        return parAddr;
    }

    public void setParAddr(String parAddr) {
        this.parAddr = parAddr;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public funcData getFuncList() {
        return funcList;
    }

    public void setFuncList(funcData funcList) {
        this.funcList = funcList;
    }

    @Override
    public String toString() {
        return "["+nwkAddr+","+parAddr+","+macAddr+","+funcList+"]";
    }
}
