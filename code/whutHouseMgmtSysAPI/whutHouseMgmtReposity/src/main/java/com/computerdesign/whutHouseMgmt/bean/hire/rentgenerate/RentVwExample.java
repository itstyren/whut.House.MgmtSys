package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentVwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentVwExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("StaffId is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("StaffId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("StaffId =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("StaffId <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("StaffId >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffId >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("StaffId <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffId <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("StaffId in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("StaffId not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffId between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffId not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("HouseId is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("HouseId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("HouseId =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("HouseId <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("HouseId >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseId >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("HouseId <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseId <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("HouseId in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("HouseId not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseId between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseId not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("StaffName is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("StaffName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("StaffName =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("StaffName <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("StaffName >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffName >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("StaffName <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("StaffName <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("StaffName like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("StaffName not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("StaffName in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("StaffName not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("StaffName between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("StaffName not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("StaffNo is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("StaffNo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(String value) {
            addCriterion("StaffNo =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(String value) {
            addCriterion("StaffNo <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(String value) {
            addCriterion("StaffNo >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("StaffNo >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(String value) {
            addCriterion("StaffNo <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(String value) {
            addCriterion("StaffNo <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLike(String value) {
            addCriterion("StaffNo like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotLike(String value) {
            addCriterion("StaffNo not like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<String> values) {
            addCriterion("StaffNo in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<String> values) {
            addCriterion("StaffNo not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(String value1, String value2) {
            addCriterion("StaffNo between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(String value1, String value2) {
            addCriterion("StaffNo not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNull() {
            addCriterion("HouseNo is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("HouseNo is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("HouseNo =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("HouseNo <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("HouseNo >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("HouseNo >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("HouseNo <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("HouseNo <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("HouseNo like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("HouseNo not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("HouseNo in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("HouseNo not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("HouseNo between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("HouseNo not between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdIsNull() {
            addCriterion("HouseStructId is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdIsNotNull() {
            addCriterion("HouseStructId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdEqualTo(Integer value) {
            addCriterion("HouseStructId =", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotEqualTo(Integer value) {
            addCriterion("HouseStructId <>", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdGreaterThan(Integer value) {
            addCriterion("HouseStructId >", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseStructId >=", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdLessThan(Integer value) {
            addCriterion("HouseStructId <", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseStructId <=", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdIn(List<Integer> values) {
            addCriterion("HouseStructId in", values, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotIn(List<Integer> values) {
            addCriterion("HouseStructId not in", values, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseStructId between", value1, value2, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseStructId not between", value1, value2, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNull() {
            addCriterion("HouseBuildArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNotNull() {
            addCriterion("HouseBuildArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaEqualTo(Double value) {
            addCriterion("HouseBuildArea =", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotEqualTo(Double value) {
            addCriterion("HouseBuildArea <>", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThan(Double value) {
            addCriterion("HouseBuildArea >", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea >=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThan(Double value) {
            addCriterion("HouseBuildArea <", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea <=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIn(List<Double> values) {
            addCriterion("HouseBuildArea in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotIn(List<Double> values) {
            addCriterion("HouseBuildArea not in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea not between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNull() {
            addCriterion("BookTime is null");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNotNull() {
            addCriterion("BookTime is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimeEqualTo(Date value) {
            addCriterion("BookTime =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterion("BookTime <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterion("BookTime >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BookTime >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterion("BookTime <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterion("BookTime <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterion("BookTime in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterion("BookTime not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterion("BookTime between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterion("BookTime not between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("ExpireTime is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("ExpireTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("ExpireTime =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("ExpireTime <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("ExpireTime >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ExpireTime >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("ExpireTime <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("ExpireTime <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("ExpireTime in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("ExpireTime not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("ExpireTime between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("ExpireTime not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeIsNull() {
            addCriterion("RentBeginTime is null");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeIsNotNull() {
            addCriterion("RentBeginTime is not null");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeEqualTo(Date value) {
            addCriterion("RentBeginTime =", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotEqualTo(Date value) {
            addCriterion("RentBeginTime <>", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeGreaterThan(Date value) {
            addCriterion("RentBeginTime >", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RentBeginTime >=", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeLessThan(Date value) {
            addCriterion("RentBeginTime <", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("RentBeginTime <=", value, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeIn(List<Date> values) {
            addCriterion("RentBeginTime in", values, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotIn(List<Date> values) {
            addCriterion("RentBeginTime not in", values, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeBetween(Date value1, Date value2) {
            addCriterion("RentBeginTime between", value1, value2, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("RentBeginTime not between", value1, value2, "rentBeginTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIsNull() {
            addCriterion("RentEndTime is null");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIsNotNull() {
            addCriterion("RentEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeEqualTo(Date value) {
            addCriterion("RentEndTime =", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotEqualTo(Date value) {
            addCriterion("RentEndTime <>", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeGreaterThan(Date value) {
            addCriterion("RentEndTime >", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RentEndTime >=", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeLessThan(Date value) {
            addCriterion("RentEndTime <", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("RentEndTime <=", value, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeIn(List<Date> values) {
            addCriterion("RentEndTime in", values, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotIn(List<Date> values) {
            addCriterion("RentEndTime not in", values, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeBetween(Date value1, Date value2) {
            addCriterion("RentEndTime between", value1, value2, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("RentEndTime not between", value1, value2, "rentEndTime");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateIsNull() {
            addCriterion("RentDiscountRate is null");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateIsNotNull() {
            addCriterion("RentDiscountRate is not null");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateEqualTo(String value) {
            addCriterion("RentDiscountRate =", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateNotEqualTo(String value) {
            addCriterion("RentDiscountRate <>", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateGreaterThan(String value) {
            addCriterion("RentDiscountRate >", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateGreaterThanOrEqualTo(String value) {
            addCriterion("RentDiscountRate >=", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateLessThan(String value) {
            addCriterion("RentDiscountRate <", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateLessThanOrEqualTo(String value) {
            addCriterion("RentDiscountRate <=", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateLike(String value) {
            addCriterion("RentDiscountRate like", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateNotLike(String value) {
            addCriterion("RentDiscountRate not like", value, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateIn(List<String> values) {
            addCriterion("RentDiscountRate in", values, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateNotIn(List<String> values) {
            addCriterion("RentDiscountRate not in", values, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateBetween(String value1, String value2) {
            addCriterion("RentDiscountRate between", value1, value2, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentDiscountRateNotBetween(String value1, String value2) {
            addCriterion("RentDiscountRate not between", value1, value2, "rentDiscountRate");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyIsNull() {
            addCriterion("RentInitMoney is null");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyIsNotNull() {
            addCriterion("RentInitMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyEqualTo(Double value) {
            addCriterion("RentInitMoney =", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyNotEqualTo(Double value) {
            addCriterion("RentInitMoney <>", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyGreaterThan(Double value) {
            addCriterion("RentInitMoney >", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("RentInitMoney >=", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyLessThan(Double value) {
            addCriterion("RentInitMoney <", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyLessThanOrEqualTo(Double value) {
            addCriterion("RentInitMoney <=", value, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyIn(List<Double> values) {
            addCriterion("RentInitMoney in", values, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyNotIn(List<Double> values) {
            addCriterion("RentInitMoney not in", values, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyBetween(Double value1, Double value2) {
            addCriterion("RentInitMoney between", value1, value2, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentInitMoneyNotBetween(Double value1, Double value2) {
            addCriterion("RentInitMoney not between", value1, value2, "rentInitMoney");
            return (Criteria) this;
        }

        public Criteria andRentIsGetIsNull() {
            addCriterion("RentIsGet is null");
            return (Criteria) this;
        }

        public Criteria andRentIsGetIsNotNull() {
            addCriterion("RentIsGet is not null");
            return (Criteria) this;
        }

        public Criteria andRentIsGetEqualTo(Byte value) {
            addCriterion("RentIsGet =", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetNotEqualTo(Byte value) {
            addCriterion("RentIsGet <>", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetGreaterThan(Byte value) {
            addCriterion("RentIsGet >", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetGreaterThanOrEqualTo(Byte value) {
            addCriterion("RentIsGet >=", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetLessThan(Byte value) {
            addCriterion("RentIsGet <", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetLessThanOrEqualTo(Byte value) {
            addCriterion("RentIsGet <=", value, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetIn(List<Byte> values) {
            addCriterion("RentIsGet in", values, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetNotIn(List<Byte> values) {
            addCriterion("RentIsGet not in", values, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetBetween(Byte value1, Byte value2) {
            addCriterion("RentIsGet between", value1, value2, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIsGetNotBetween(Byte value1, Byte value2) {
            addCriterion("RentIsGet not between", value1, value2, "rentIsGet");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNull() {
            addCriterion("RentId is null");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNotNull() {
            addCriterion("RentId is not null");
            return (Criteria) this;
        }

        public Criteria andRentIdEqualTo(Integer value) {
            addCriterion("RentId =", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotEqualTo(Integer value) {
            addCriterion("RentId <>", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThan(Integer value) {
            addCriterion("RentId >", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentId >=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThan(Integer value) {
            addCriterion("RentId <", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThanOrEqualTo(Integer value) {
            addCriterion("RentId <=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdIn(List<Integer> values) {
            addCriterion("RentId in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotIn(List<Integer> values) {
            addCriterion("RentId not in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdBetween(Integer value1, Integer value2) {
            addCriterion("RentId between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RentId not between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentMoneyIsNull() {
            addCriterion("RentMoney is null");
            return (Criteria) this;
        }

        public Criteria andRentMoneyIsNotNull() {
            addCriterion("RentMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRentMoneyEqualTo(Double value) {
            addCriterion("RentMoney =", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyNotEqualTo(Double value) {
            addCriterion("RentMoney <>", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyGreaterThan(Double value) {
            addCriterion("RentMoney >", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("RentMoney >=", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyLessThan(Double value) {
            addCriterion("RentMoney <", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyLessThanOrEqualTo(Double value) {
            addCriterion("RentMoney <=", value, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyIn(List<Double> values) {
            addCriterion("RentMoney in", values, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyNotIn(List<Double> values) {
            addCriterion("RentMoney not in", values, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyBetween(Double value1, Double value2) {
            addCriterion("RentMoney between", value1, value2, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentMoneyNotBetween(Double value1, Double value2) {
            addCriterion("RentMoney not between", value1, value2, "rentMoney");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNull() {
            addCriterion("RentType is null");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNotNull() {
            addCriterion("RentType is not null");
            return (Criteria) this;
        }

        public Criteria andRentTypeEqualTo(String value) {
            addCriterion("RentType =", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotEqualTo(String value) {
            addCriterion("RentType <>", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThan(String value) {
            addCriterion("RentType >", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RentType >=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThan(String value) {
            addCriterion("RentType <", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThanOrEqualTo(String value) {
            addCriterion("RentType <=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLike(String value) {
            addCriterion("RentType like", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotLike(String value) {
            addCriterion("RentType not like", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeIn(List<String> values) {
            addCriterion("RentType in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotIn(List<String> values) {
            addCriterion("RentType not in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeBetween(String value1, String value2) {
            addCriterion("RentType between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotBetween(String value1, String value2) {
            addCriterion("RentType not between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andResidentIdIsNull() {
            addCriterion("ResidentId is null");
            return (Criteria) this;
        }

        public Criteria andResidentIdIsNotNull() {
            addCriterion("ResidentId is not null");
            return (Criteria) this;
        }

        public Criteria andResidentIdEqualTo(Integer value) {
            addCriterion("ResidentId =", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotEqualTo(Integer value) {
            addCriterion("ResidentId <>", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdGreaterThan(Integer value) {
            addCriterion("ResidentId >", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ResidentId >=", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdLessThan(Integer value) {
            addCriterion("ResidentId <", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdLessThanOrEqualTo(Integer value) {
            addCriterion("ResidentId <=", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdIn(List<Integer> values) {
            addCriterion("ResidentId in", values, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotIn(List<Integer> values) {
            addCriterion("ResidentId not in", values, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdBetween(Integer value1, Integer value2) {
            addCriterion("ResidentId between", value1, value2, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ResidentId not between", value1, value2, "residentId");
            return (Criteria) this;
        }

        public Criteria andEmployTypeIsNull() {
            addCriterion("EmployType is null");
            return (Criteria) this;
        }

        public Criteria andEmployTypeIsNotNull() {
            addCriterion("EmployType is not null");
            return (Criteria) this;
        }

        public Criteria andEmployTypeEqualTo(String value) {
            addCriterion("EmployType =", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeNotEqualTo(String value) {
            addCriterion("EmployType <>", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeGreaterThan(String value) {
            addCriterion("EmployType >", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EmployType >=", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeLessThan(String value) {
            addCriterion("EmployType <", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeLessThanOrEqualTo(String value) {
            addCriterion("EmployType <=", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeLike(String value) {
            addCriterion("EmployType like", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeNotLike(String value) {
            addCriterion("EmployType not like", value, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeIn(List<String> values) {
            addCriterion("EmployType in", values, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeNotIn(List<String> values) {
            addCriterion("EmployType not in", values, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeBetween(String value1, String value2) {
            addCriterion("EmployType between", value1, value2, "employType");
            return (Criteria) this;
        }

        public Criteria andEmployTypeNotBetween(String value1, String value2) {
            addCriterion("EmployType not between", value1, value2, "employType");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIsNull() {
            addCriterion("StaffDeptId is null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIsNotNull() {
            addCriterion("StaffDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdEqualTo(Integer value) {
            addCriterion("StaffDeptId =", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotEqualTo(Integer value) {
            addCriterion("StaffDeptId <>", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdGreaterThan(Integer value) {
            addCriterion("StaffDeptId >", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffDeptId >=", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdLessThan(Integer value) {
            addCriterion("StaffDeptId <", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffDeptId <=", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIn(List<Integer> values) {
            addCriterion("StaffDeptId in", values, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotIn(List<Integer> values) {
            addCriterion("StaffDeptId not in", values, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffDeptId between", value1, value2, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffDeptId not between", value1, value2, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIsNull() {
            addCriterion("StaffDeptName is null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIsNotNull() {
            addCriterion("StaffDeptName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameEqualTo(String value) {
            addCriterion("StaffDeptName =", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotEqualTo(String value) {
            addCriterion("StaffDeptName <>", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameGreaterThan(String value) {
            addCriterion("StaffDeptName >", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffDeptName >=", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLessThan(String value) {
            addCriterion("StaffDeptName <", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLessThanOrEqualTo(String value) {
            addCriterion("StaffDeptName <=", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLike(String value) {
            addCriterion("StaffDeptName like", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotLike(String value) {
            addCriterion("StaffDeptName not like", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIn(List<String> values) {
            addCriterion("StaffDeptName in", values, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotIn(List<String> values) {
            addCriterion("StaffDeptName not in", values, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameBetween(String value1, String value2) {
            addCriterion("StaffDeptName between", value1, value2, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotBetween(String value1, String value2) {
            addCriterion("StaffDeptName not between", value1, value2, "staffDeptName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}