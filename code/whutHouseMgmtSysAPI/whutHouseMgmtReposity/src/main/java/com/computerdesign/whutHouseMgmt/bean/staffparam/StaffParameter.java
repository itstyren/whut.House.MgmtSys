package com.computerdesign.whutHouseMgmt.bean.staffparam;

public class StaffParameter {
    private Integer staffParamId;

    private String staffParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private Integer staffParamVal;

    private Integer staffParamSpouseVal;

    private Float staffParamHouseArea;

    private Boolean isDelete;

    public Integer getStaffParamId() {
        return staffParamId;
    }

    public void setStaffParamId(Integer staffParamId) {
        this.staffParamId = staffParamId;
    }

    public String getStaffParamName() {
        return staffParamName;
    }

    public void setStaffParamName(String staffParamName) {
        this.staffParamName = staffParamName == null ? null : staffParamName.trim();
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

    public Integer getStaffParamVal() {
        return staffParamVal;
    }

    public void setStaffParamVal(Integer staffParamVal) {
        this.staffParamVal = staffParamVal;
    }

    public Integer getStaffParamSpouseVal() {
        return staffParamSpouseVal;
    }

    public void setStaffParamSpouseVal(Integer staffParamSpouseVal) {
        this.staffParamSpouseVal = staffParamSpouseVal;
    }

    public Float getStaffParamHouseArea() {
        return staffParamHouseArea;
    }

    public void setStaffParamHouseArea(Float staffParamHouseArea) {
        this.staffParamHouseArea = staffParamHouseArea;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

	public StaffParameter() {
		super();
	}

	public StaffParameter(String staffParamName, Integer paramTypeId, String paramTypeName, Boolean isDelete) {
		super();
		this.staffParamName = staffParamName;
		this.paramTypeId = paramTypeId;
		this.paramTypeName = paramTypeName;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "StaffParameter [staffParamId=" + staffParamId + ", staffParamName=" + staffParamName + ", paramTypeId="
				+ paramTypeId + ", paramTypeName=" + paramTypeName + ", staffParamVal=" + staffParamVal
				+ ", staffParamSpouseVal=" + staffParamSpouseVal + ", staffParamHouseArea=" + staffParamHouseArea
				+ ", isDelete=" + isDelete + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramTypeId == null) ? 0 : paramTypeId.hashCode());
		result = prime * result + ((staffParamName == null) ? 0 : staffParamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffParameter other = (StaffParameter) obj;
		if (paramTypeId == null) {
			if (other.paramTypeId != null)
				return false;
		} else if (!paramTypeId.equals(other.paramTypeId))
			return false;
		if (staffParamName == null) {
			if (other.staffParamName != null)
				return false;
		} else if (!staffParamName.equals(other.staffParamName))
			return false;
		return true;
	}
    
	
	
}