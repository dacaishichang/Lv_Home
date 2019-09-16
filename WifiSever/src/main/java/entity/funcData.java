package entity;


public class funcData {
    private Integer typeCode;
    private String type;
    private Integer id;
    private Integer cycle;
    private Float data;

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n["+typeCode+","+type+","+id+","+cycle+","+data+"]";
    }
}
