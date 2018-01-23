package com.computerdesign.whutHouseMgmt.bean.houseparam;

public class HouseParameter {
    private Integer houseParamId;

    private String houseParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private String houseParamRel;

    private Boolean isDelete;

    public Integer getHouseParamId() {
        return houseParamId;
    }

    public void setHouseParamId(Integer houseParamId) {
        this.houseParamId = houseParamId;
    }

    public String getHouseParamName() {
        return houseParamName;
    }

    public void setHouseParamName(String houseParamName) {
        this.houseParamName = houseParamName == null ? null : houseParamName.trim();
    }

    public Integer getParamTypeId() {
        return paramTypeId;
    }

    public void setParamTypeId(Integer paramTypeId) {
        this.paramTypeId = paramTypeId;
    }

    public String getParamTypeName() {
        return paramTypeName;
    }

    public void setParamTypeName(String paramTypeName) {
        this.paramTypeName = paramTypeName == null ? null : paramTypeName.trim();
    }

    public String getHouseParamRel() {
        return houseParamRel;
    }

    public void setHouseParamRel(String houseParamRel) {
        this.houseParamRel = houseParamRel == null ? null : houseParamRel.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

	@Override
	public String toString() {
		return "HouseParameter [houseParamId=" + houseParamId + ", houseParamName=" + houseParamName + ", paramTypeId="
				+ paramTypeId + ", paramTypeName=" + paramTypeName + ", houseParamRel=" + houseParamRel + ", isDelete="
				+ isDelete + "]";
	}
    
    
}