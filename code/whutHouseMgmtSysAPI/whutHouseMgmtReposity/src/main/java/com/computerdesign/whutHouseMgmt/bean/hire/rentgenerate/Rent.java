package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

public class Rent {
    private Integer id;

    private Integer residentId;

    private String rentType;

    private Double rentMoney;

    private Byte isGet;

    private Date beginTime;

    private Date endTime;

    private Date employmentDate;

    private String employType;

    private String discountRate;

    private Double initMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public Double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(Double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public Byte getIsGet() {
        return isGet;
    }

    public void setIsGet(Byte isGet) {
        this.isGet = isGet;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getEmployType() {
        return employType;
    }

    public void setEmployType(String employType) {
        this.employType = employType == null ? null : employType.trim();
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate == null ? null : discountRate.trim();
    }

    public Double getInitMoney() {
        return initMoney;
    }

    public void setInitMoney(Double initMoney) {
        this.initMoney = initMoney;
    }

    /*除去Rent表里面的id、RentMoney、DiscountRate、InitMoney字段，因为这些字段通过计算及类型转换后存在精度差别
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + ((employType == null) ? 0 : employType.hashCode());
		result = prime * result + ((employmentDate == null) ? 0 : employmentDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((isGet == null) ? 0 : isGet.hashCode());
		result = prime * result + ((rentType == null) ? 0 : rentType.hashCode());
		result = prime * result + ((residentId == null) ? 0 : residentId.hashCode());
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
		Rent other = (Rent) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (employType == null) {
			if (other.employType != null)
				return false;
		} else if (!employType.equals(other.employType))
			return false;
		if (employmentDate == null) {
			if (other.employmentDate != null)
				return false;
		} else if (!employmentDate.equals(other.employmentDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (isGet == null) {
			if (other.isGet != null)
				return false;
		} else if (!isGet.equals(other.isGet))
			return false;
		if (rentType == null) {
			if (other.rentType != null)
				return false;
		} else if (!rentType.equals(other.rentType))
			return false;
		if (residentId == null) {
			if (other.residentId != null)
				return false;
		} else if (!residentId.equals(other.residentId))
			return false;
		return true;
	}

    
}