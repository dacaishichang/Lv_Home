package cn.nuc.dto;

import cn.nuc.entity.HomeTemperatureHistory;

public class TemperatureDto extends HomeTemperatureHistory {
    private Integer pId;

    public Integer getpId() {
        return pId;
    }

    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

}
