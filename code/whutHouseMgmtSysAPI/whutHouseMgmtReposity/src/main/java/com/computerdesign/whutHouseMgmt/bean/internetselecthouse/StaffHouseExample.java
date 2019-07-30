package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StaffHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffHouseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andHouseRelIsNull() {
            addCriterion("HouseRel is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelIsNotNull() {
            addCriterion("HouseRel is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelEqualTo(Integer value) {
            addCriterion("HouseRel =", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotEqualTo(Integer value) {
            addCriterion("HouseRel <>", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelGreaterThan(Integer value) {
            addCriterion("HouseRel >", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseRel >=", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelLessThan(Integer value) {
            addCriterion("HouseRel <", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelLessThanOrEqualTo(Integer value) {
            addCriterion("HouseRel <=", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelIn(List<Integer> values) {
            addCriterion("HouseRel in", values, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotIn(List<Integer> values) {
            addCriterion("HouseRel not in", values, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelBetween(Integer value1, Integer value2) {
            addCriterion("HouseRel between", value1, value2, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseRel not between", value1, value2, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIsNull() {
            addCriterion("HouseRelName is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIsNotNull() {
            addCriterion("HouseRelName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameEqualTo(String value) {
            addCriterion("HouseRelName =", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotEqualTo(String value) {
            addCriterion("HouseRelName <>", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameGreaterThan(String value) {
            addCriterion("HouseRelName >", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseRelName >=", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLessThan(String value) {
            addCriterion("HouseRelName <", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLessThanOrEqualTo(String value) {
            addCriterion("HouseRelName <=", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLike(String value) {
            addCriterion("HouseRelName like", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotLike(String value) {
            addCriterion("HouseRelName not like", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIn(List<String> values) {
            addCriterion("HouseRelName in", values, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotIn(List<String> values) {
            addCriterion("HouseRelName not in", values, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameBetween(String value1, String value2) {
            addCriterion("HouseRelName between", value1, value2, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotBetween(String value1, String value2) {
            addCriterion("HouseRelName not between", value1, value2, "houseRelName");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("IsDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IsDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("IsDelete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("IsDelete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("IsDelete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDelete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("IsDelete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDelete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("IsDelete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("IsDelete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDelete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDelete not between", value1, value2, "isDelete");
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

        public Criteria andFamilyCodeIsNull() {
            addCriterion("FamilyCode is null");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeIsNotNull() {
            addCriterion("FamilyCode is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeEqualTo(String value) {
            addCriterion("FamilyCode =", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotEqualTo(String value) {
            addCriterion("FamilyCode <>", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeGreaterThan(String value) {
            addCriterion("FamilyCode >", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FamilyCode >=", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeLessThan(String value) {
            addCriterion("FamilyCode <", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeLessThanOrEqualTo(String value) {
            addCriterion("FamilyCode <=", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeLike(String value) {
            addCriterion("FamilyCode like", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotLike(String value) {
            addCriterion("FamilyCode not like", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeIn(List<String> values) {
            addCriterion("FamilyCode in", values, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotIn(List<String> values) {
            addCriterion("FamilyCode not in", values, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeBetween(String value1, String value2) {
            addCriterion("FamilyCode between", value1, value2, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotBetween(String value1, String value2) {
            addCriterion("FamilyCode not between", value1, value2, "familyCode");
            return (Criteria) this;
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

        public Criteria andStaffSexIsNull() {
            addCriterion("StaffSex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("StaffSex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("StaffSex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("StaffSex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("StaffSex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("StaffSex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("StaffSex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("StaffSex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("StaffSex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("StaffSex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("StaffSex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("StaffSex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("StaffSex not between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateIsNull() {
            addCriterion("StaffMarriageState is null");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateIsNotNull() {
            addCriterion("StaffMarriageState is not null");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateEqualTo(String value) {
            addCriterion("StaffMarriageState =", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateNotEqualTo(String value) {
            addCriterion("StaffMarriageState <>", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateGreaterThan(String value) {
            addCriterion("StaffMarriageState >", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateGreaterThanOrEqualTo(String value) {
            addCriterion("StaffMarriageState >=", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateLessThan(String value) {
            addCriterion("StaffMarriageState <", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateLessThanOrEqualTo(String value) {
            addCriterion("StaffMarriageState <=", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateLike(String value) {
            addCriterion("StaffMarriageState like", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateNotLike(String value) {
            addCriterion("StaffMarriageState not like", value, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateIn(List<String> values) {
            addCriterion("StaffMarriageState in", values, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateNotIn(List<String> values) {
            addCriterion("StaffMarriageState not in", values, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateBetween(String value1, String value2) {
            addCriterion("StaffMarriageState between", value1, value2, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffMarriageStateNotBetween(String value1, String value2) {
            addCriterion("StaffMarriageState not between", value1, value2, "staffMarriageState");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdIsNull() {
            addCriterion("StaffTitleId is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdIsNotNull() {
            addCriterion("StaffTitleId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdEqualTo(Integer value) {
            addCriterion("StaffTitleId =", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotEqualTo(Integer value) {
            addCriterion("StaffTitleId <>", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdGreaterThan(Integer value) {
            addCriterion("StaffTitleId >", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleId >=", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdLessThan(Integer value) {
            addCriterion("StaffTitleId <", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleId <=", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdIn(List<Integer> values) {
            addCriterion("StaffTitleId in", values, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotIn(List<Integer> values) {
            addCriterion("StaffTitleId not in", values, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleId between", value1, value2, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleId not between", value1, value2, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIsNull() {
            addCriterion("StaffTitleName is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIsNotNull() {
            addCriterion("StaffTitleName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameEqualTo(String value) {
            addCriterion("StaffTitleName =", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotEqualTo(String value) {
            addCriterion("StaffTitleName <>", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameGreaterThan(String value) {
            addCriterion("StaffTitleName >", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffTitleName >=", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLessThan(String value) {
            addCriterion("StaffTitleName <", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLessThanOrEqualTo(String value) {
            addCriterion("StaffTitleName <=", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLike(String value) {
            addCriterion("StaffTitleName like", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotLike(String value) {
            addCriterion("StaffTitleName not like", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIn(List<String> values) {
            addCriterion("StaffTitleName in", values, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotIn(List<String> values) {
            addCriterion("StaffTitleName not in", values, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameBetween(String value1, String value2) {
            addCriterion("StaffTitleName between", value1, value2, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotBetween(String value1, String value2) {
            addCriterion("StaffTitleName not between", value1, value2, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIsNull() {
            addCriterion("StaffTitleVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIsNotNull() {
            addCriterion("StaffTitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValEqualTo(Integer value) {
            addCriterion("StaffTitleVal =", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotEqualTo(Integer value) {
            addCriterion("StaffTitleVal <>", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValGreaterThan(Integer value) {
            addCriterion("StaffTitleVal >", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleVal >=", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValLessThan(Integer value) {
            addCriterion("StaffTitleVal <", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleVal <=", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIn(List<Integer> values) {
            addCriterion("StaffTitleVal in", values, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotIn(List<Integer> values) {
            addCriterion("StaffTitleVal not in", values, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleVal between", value1, value2, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleVal not between", value1, value2, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIsNull() {
            addCriterion("StaffSpouseTitleVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIsNotNull() {
            addCriterion("StaffSpouseTitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal =", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal <>", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValGreaterThan(Integer value) {
            addCriterion("StaffSpouseTitleVal >", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal >=", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValLessThan(Integer value) {
            addCriterion("StaffSpouseTitleVal <", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal <=", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIn(List<Integer> values) {
            addCriterion("StaffSpouseTitleVal in", values, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotIn(List<Integer> values) {
            addCriterion("StaffSpouseTitleVal not in", values, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseTitleVal between", value1, value2, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseTitleVal not between", value1, value2, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIsNull() {
            addCriterion("StaffPostId is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIsNotNull() {
            addCriterion("StaffPostId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdEqualTo(Integer value) {
            addCriterion("StaffPostId =", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotEqualTo(Integer value) {
            addCriterion("StaffPostId <>", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdGreaterThan(Integer value) {
            addCriterion("StaffPostId >", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffPostId >=", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdLessThan(Integer value) {
            addCriterion("StaffPostId <", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffPostId <=", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIn(List<Integer> values) {
            addCriterion("StaffPostId in", values, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotIn(List<Integer> values) {
            addCriterion("StaffPostId not in", values, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostId between", value1, value2, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostId not between", value1, value2, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIsNull() {
            addCriterion("StaffPostName is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIsNotNull() {
            addCriterion("StaffPostName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameEqualTo(String value) {
            addCriterion("StaffPostName =", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotEqualTo(String value) {
            addCriterion("StaffPostName <>", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameGreaterThan(String value) {
            addCriterion("StaffPostName >", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffPostName >=", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLessThan(String value) {
            addCriterion("StaffPostName <", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLessThanOrEqualTo(String value) {
            addCriterion("StaffPostName <=", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLike(String value) {
            addCriterion("StaffPostName like", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotLike(String value) {
            addCriterion("StaffPostName not like", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIn(List<String> values) {
            addCriterion("StaffPostName in", values, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotIn(List<String> values) {
            addCriterion("StaffPostName not in", values, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameBetween(String value1, String value2) {
            addCriterion("StaffPostName between", value1, value2, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotBetween(String value1, String value2) {
            addCriterion("StaffPostName not between", value1, value2, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIsNull() {
            addCriterion("StaffPostVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIsNotNull() {
            addCriterion("StaffPostVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValEqualTo(Integer value) {
            addCriterion("StaffPostVal =", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotEqualTo(Integer value) {
            addCriterion("StaffPostVal <>", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValGreaterThan(Integer value) {
            addCriterion("StaffPostVal >", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffPostVal >=", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValLessThan(Integer value) {
            addCriterion("StaffPostVal <", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffPostVal <=", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIn(List<Integer> values) {
            addCriterion("StaffPostVal in", values, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotIn(List<Integer> values) {
            addCriterion("StaffPostVal not in", values, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostVal between", value1, value2, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostVal not between", value1, value2, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIsNull() {
            addCriterion("StaffSpousePostVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIsNotNull() {
            addCriterion("StaffSpousePostVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal =", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal <>", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValGreaterThan(Integer value) {
            addCriterion("StaffSpousePostVal >", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal >=", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValLessThan(Integer value) {
            addCriterion("StaffSpousePostVal <", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal <=", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIn(List<Integer> values) {
            addCriterion("StaffSpousePostVal in", values, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotIn(List<Integer> values) {
            addCriterion("StaffSpousePostVal not in", values, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpousePostVal between", value1, value2, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpousePostVal not between", value1, value2, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIsNull() {
            addCriterion("StaffTypeId is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIsNotNull() {
            addCriterion("StaffTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdEqualTo(Integer value) {
            addCriterion("StaffTypeId =", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotEqualTo(Integer value) {
            addCriterion("StaffTypeId <>", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdGreaterThan(Integer value) {
            addCriterion("StaffTypeId >", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTypeId >=", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdLessThan(Integer value) {
            addCriterion("StaffTypeId <", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTypeId <=", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIn(List<Integer> values) {
            addCriterion("StaffTypeId in", values, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotIn(List<Integer> values) {
            addCriterion("StaffTypeId not in", values, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffTypeId between", value1, value2, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTypeId not between", value1, value2, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIsNull() {
            addCriterion("StaffTypeName is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIsNotNull() {
            addCriterion("StaffTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameEqualTo(String value) {
            addCriterion("StaffTypeName =", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotEqualTo(String value) {
            addCriterion("StaffTypeName <>", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameGreaterThan(String value) {
            addCriterion("StaffTypeName >", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffTypeName >=", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLessThan(String value) {
            addCriterion("StaffTypeName <", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLessThanOrEqualTo(String value) {
            addCriterion("StaffTypeName <=", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLike(String value) {
            addCriterion("StaffTypeName like", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotLike(String value) {
            addCriterion("StaffTypeName not like", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIn(List<String> values) {
            addCriterion("StaffTypeName in", values, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotIn(List<String> values) {
            addCriterion("StaffTypeName not in", values, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameBetween(String value1, String value2) {
            addCriterion("StaffTypeName between", value1, value2, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotBetween(String value1, String value2) {
            addCriterion("StaffTypeName not between", value1, value2, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIsNull() {
            addCriterion("StaffStatusId is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIsNotNull() {
            addCriterion("StaffStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdEqualTo(Integer value) {
            addCriterion("StaffStatusId =", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotEqualTo(Integer value) {
            addCriterion("StaffStatusId <>", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdGreaterThan(Integer value) {
            addCriterion("StaffStatusId >", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffStatusId >=", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdLessThan(Integer value) {
            addCriterion("StaffStatusId <", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffStatusId <=", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIn(List<Integer> values) {
            addCriterion("StaffStatusId in", values, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotIn(List<Integer> values) {
            addCriterion("StaffStatusId not in", values, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffStatusId between", value1, value2, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffStatusId not between", value1, value2, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIsNull() {
            addCriterion("StaffStatusName is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIsNotNull() {
            addCriterion("StaffStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameEqualTo(String value) {
            addCriterion("StaffStatusName =", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotEqualTo(String value) {
            addCriterion("StaffStatusName <>", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameGreaterThan(String value) {
            addCriterion("StaffStatusName >", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffStatusName >=", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLessThan(String value) {
            addCriterion("StaffStatusName <", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLessThanOrEqualTo(String value) {
            addCriterion("StaffStatusName <=", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLike(String value) {
            addCriterion("StaffStatusName like", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotLike(String value) {
            addCriterion("StaffStatusName not like", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIn(List<String> values) {
            addCriterion("StaffStatusName in", values, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotIn(List<String> values) {
            addCriterion("StaffStatusName not in", values, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameBetween(String value1, String value2) {
            addCriterion("StaffStatusName between", value1, value2, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotBetween(String value1, String value2) {
            addCriterion("StaffStatusName not between", value1, value2, "staffStatusName");
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

        public Criteria andStaffCodeIsNull() {
            addCriterion("StaffCode is null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("StaffCode is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeEqualTo(String value) {
            addCriterion("StaffCode =", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotEqualTo(String value) {
            addCriterion("StaffCode <>", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThan(String value) {
            addCriterion("StaffCode >", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("StaffCode >=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThan(String value) {
            addCriterion("StaffCode <", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(String value) {
            addCriterion("StaffCode <=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLike(String value) {
            addCriterion("StaffCode like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotLike(String value) {
            addCriterion("StaffCode not like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIn(List<String> values) {
            addCriterion("StaffCode in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotIn(List<String> values) {
            addCriterion("StaffCode not in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeBetween(String value1, String value2) {
            addCriterion("StaffCode between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotBetween(String value1, String value2) {
            addCriterion("StaffCode not between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeIsNull() {
            addCriterion("StaffJoinTime is null");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeIsNotNull() {
            addCriterion("StaffJoinTime is not null");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeEqualTo(Date value) {
            addCriterionForJDBCDate("StaffJoinTime =", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StaffJoinTime <>", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StaffJoinTime >", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffJoinTime >=", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeLessThan(Date value) {
            addCriterionForJDBCDate("StaffJoinTime <", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffJoinTime <=", value, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeIn(List<Date> values) {
            addCriterionForJDBCDate("StaffJoinTime in", values, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StaffJoinTime not in", values, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffJoinTime between", value1, value2, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffJoinTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffJoinTime not between", value1, value2, "staffJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeIsNull() {
            addCriterion("StaffRetireTime is null");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeIsNotNull() {
            addCriterion("StaffRetireTime is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeEqualTo(Date value) {
            addCriterionForJDBCDate("StaffRetireTime =", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StaffRetireTime <>", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StaffRetireTime >", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffRetireTime >=", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeLessThan(Date value) {
            addCriterionForJDBCDate("StaffRetireTime <", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffRetireTime <=", value, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("StaffRetireTime in", values, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StaffRetireTime not in", values, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffRetireTime between", value1, value2, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffRetireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffRetireTime not between", value1, value2, "staffRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffTelIsNull() {
            addCriterion("StaffTel is null");
            return (Criteria) this;
        }

        public Criteria andStaffTelIsNotNull() {
            addCriterion("StaffTel is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTelEqualTo(String value) {
            addCriterion("StaffTel =", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelNotEqualTo(String value) {
            addCriterion("StaffTel <>", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelGreaterThan(String value) {
            addCriterion("StaffTel >", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelGreaterThanOrEqualTo(String value) {
            addCriterion("StaffTel >=", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelLessThan(String value) {
            addCriterion("StaffTel <", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelLessThanOrEqualTo(String value) {
            addCriterion("StaffTel <=", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelLike(String value) {
            addCriterion("StaffTel like", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelNotLike(String value) {
            addCriterion("StaffTel not like", value, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelIn(List<String> values) {
            addCriterion("StaffTel in", values, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelNotIn(List<String> values) {
            addCriterion("StaffTel not in", values, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelBetween(String value1, String value2) {
            addCriterion("StaffTel between", value1, value2, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffTelNotBetween(String value1, String value2) {
            addCriterion("StaffTel not between", value1, value2, "staffTel");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIsNull() {
            addCriterion("StaffRemark is null");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIsNotNull() {
            addCriterion("StaffRemark is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkEqualTo(String value) {
            addCriterion("StaffRemark =", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotEqualTo(String value) {
            addCriterion("StaffRemark <>", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkGreaterThan(String value) {
            addCriterion("StaffRemark >", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("StaffRemark >=", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLessThan(String value) {
            addCriterion("StaffRemark <", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLessThanOrEqualTo(String value) {
            addCriterion("StaffRemark <=", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkLike(String value) {
            addCriterion("StaffRemark like", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotLike(String value) {
            addCriterion("StaffRemark not like", value, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkIn(List<String> values) {
            addCriterion("StaffRemark in", values, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotIn(List<String> values) {
            addCriterion("StaffRemark not in", values, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkBetween(String value1, String value2) {
            addCriterion("StaffRemark between", value1, value2, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffRemarkNotBetween(String value1, String value2) {
            addCriterion("StaffRemark not between", value1, value2, "staffRemark");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameIsNull() {
            addCriterion("StaffSpouseName is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameIsNotNull() {
            addCriterion("StaffSpouseName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameEqualTo(String value) {
            addCriterion("StaffSpouseName =", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotEqualTo(String value) {
            addCriterion("StaffSpouseName <>", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameGreaterThan(String value) {
            addCriterion("StaffSpouseName >", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseName >=", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLessThan(String value) {
            addCriterion("StaffSpouseName <", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseName <=", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLike(String value) {
            addCriterion("StaffSpouseName like", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotLike(String value) {
            addCriterion("StaffSpouseName not like", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameIn(List<String> values) {
            addCriterion("StaffSpouseName in", values, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotIn(List<String> values) {
            addCriterion("StaffSpouseName not in", values, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameBetween(String value1, String value2) {
            addCriterion("StaffSpouseName between", value1, value2, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseName not between", value1, value2, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeIsNull() {
            addCriterion("StaffSpouseCode is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeIsNotNull() {
            addCriterion("StaffSpouseCode is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeEqualTo(String value) {
            addCriterion("StaffSpouseCode =", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeNotEqualTo(String value) {
            addCriterion("StaffSpouseCode <>", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeGreaterThan(String value) {
            addCriterion("StaffSpouseCode >", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseCode >=", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeLessThan(String value) {
            addCriterion("StaffSpouseCode <", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseCode <=", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeLike(String value) {
            addCriterion("StaffSpouseCode like", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeNotLike(String value) {
            addCriterion("StaffSpouseCode not like", value, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeIn(List<String> values) {
            addCriterion("StaffSpouseCode in", values, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeNotIn(List<String> values) {
            addCriterion("StaffSpouseCode not in", values, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeBetween(String value1, String value2) {
            addCriterion("StaffSpouseCode between", value1, value2, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseCodeNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseCode not between", value1, value2, "staffSpouseCode");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameIsNull() {
            addCriterion("StaffSpouseTitleName is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameIsNotNull() {
            addCriterion("StaffSpouseTitleName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameEqualTo(String value) {
            addCriterion("StaffSpouseTitleName =", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameNotEqualTo(String value) {
            addCriterion("StaffSpouseTitleName <>", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameGreaterThan(String value) {
            addCriterion("StaffSpouseTitleName >", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseTitleName >=", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameLessThan(String value) {
            addCriterion("StaffSpouseTitleName <", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseTitleName <=", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameLike(String value) {
            addCriterion("StaffSpouseTitleName like", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameNotLike(String value) {
            addCriterion("StaffSpouseTitleName not like", value, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameIn(List<String> values) {
            addCriterion("StaffSpouseTitleName in", values, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameNotIn(List<String> values) {
            addCriterion("StaffSpouseTitleName not in", values, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameBetween(String value1, String value2) {
            addCriterion("StaffSpouseTitleName between", value1, value2, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleNameNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseTitleName not between", value1, value2, "staffSpouseTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameIsNull() {
            addCriterion("StaffSpousePostName is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameIsNotNull() {
            addCriterion("StaffSpousePostName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameEqualTo(String value) {
            addCriterion("StaffSpousePostName =", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameNotEqualTo(String value) {
            addCriterion("StaffSpousePostName <>", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameGreaterThan(String value) {
            addCriterion("StaffSpousePostName >", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpousePostName >=", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameLessThan(String value) {
            addCriterion("StaffSpousePostName <", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameLessThanOrEqualTo(String value) {
            addCriterion("StaffSpousePostName <=", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameLike(String value) {
            addCriterion("StaffSpousePostName like", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameNotLike(String value) {
            addCriterion("StaffSpousePostName not like", value, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameIn(List<String> values) {
            addCriterion("StaffSpousePostName in", values, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameNotIn(List<String> values) {
            addCriterion("StaffSpousePostName not in", values, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameBetween(String value1, String value2) {
            addCriterion("StaffSpousePostName between", value1, value2, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostNameNotBetween(String value1, String value2) {
            addCriterion("StaffSpousePostName not between", value1, value2, "staffSpousePostName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptIsNull() {
            addCriterion("StaffSpouseDept is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptIsNotNull() {
            addCriterion("StaffSpouseDept is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptEqualTo(String value) {
            addCriterion("StaffSpouseDept =", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptNotEqualTo(String value) {
            addCriterion("StaffSpouseDept <>", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptGreaterThan(String value) {
            addCriterion("StaffSpouseDept >", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseDept >=", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptLessThan(String value) {
            addCriterion("StaffSpouseDept <", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseDept <=", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptLike(String value) {
            addCriterion("StaffSpouseDept like", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptNotLike(String value) {
            addCriterion("StaffSpouseDept not like", value, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptIn(List<String> values) {
            addCriterion("StaffSpouseDept in", values, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptNotIn(List<String> values) {
            addCriterion("StaffSpouseDept not in", values, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptBetween(String value1, String value2) {
            addCriterion("StaffSpouseDept between", value1, value2, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseDeptNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseDept not between", value1, value2, "staffSpouseDept");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoIsNull() {
            addCriterion("StaffSpouseNo is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoIsNotNull() {
            addCriterion("StaffSpouseNo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoEqualTo(Integer value) {
            addCriterion("StaffSpouseNo =", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoNotEqualTo(Integer value) {
            addCriterion("StaffSpouseNo <>", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoGreaterThan(Integer value) {
            addCriterion("StaffSpouseNo >", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseNo >=", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoLessThan(Integer value) {
            addCriterion("StaffSpouseNo <", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseNo <=", value, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoIn(List<Integer> values) {
            addCriterion("StaffSpouseNo in", values, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoNotIn(List<Integer> values) {
            addCriterion("StaffSpouseNo not in", values, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseNo between", value1, value2, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNoNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseNo not between", value1, value2, "staffSpouseNo");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindIsNull() {
            addCriterion("StaffSpouseKind is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindIsNotNull() {
            addCriterion("StaffSpouseKind is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindEqualTo(Integer value) {
            addCriterion("StaffSpouseKind =", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNotEqualTo(Integer value) {
            addCriterion("StaffSpouseKind <>", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindGreaterThan(Integer value) {
            addCriterion("StaffSpouseKind >", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseKind >=", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindLessThan(Integer value) {
            addCriterion("StaffSpouseKind <", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseKind <=", value, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindIn(List<Integer> values) {
            addCriterion("StaffSpouseKind in", values, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNotIn(List<Integer> values) {
            addCriterion("StaffSpouseKind not in", values, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseKind between", value1, value2, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseKind not between", value1, value2, "staffSpouseKind");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameIsNull() {
            addCriterion("StaffSpouseKindName is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameIsNotNull() {
            addCriterion("StaffSpouseKindName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameEqualTo(String value) {
            addCriterion("StaffSpouseKindName =", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameNotEqualTo(String value) {
            addCriterion("StaffSpouseKindName <>", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameGreaterThan(String value) {
            addCriterion("StaffSpouseKindName >", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseKindName >=", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameLessThan(String value) {
            addCriterion("StaffSpouseKindName <", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseKindName <=", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameLike(String value) {
            addCriterion("StaffSpouseKindName like", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameNotLike(String value) {
            addCriterion("StaffSpouseKindName not like", value, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameIn(List<String> values) {
            addCriterion("StaffSpouseKindName in", values, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameNotIn(List<String> values) {
            addCriterion("StaffSpouseKindName not in", values, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameBetween(String value1, String value2) {
            addCriterion("StaffSpouseKindName between", value1, value2, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseKindNameNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseKindName not between", value1, value2, "staffSpouseKindName");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageIsNull() {
            addCriterion("StaffIsDeptManage is null");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageIsNotNull() {
            addCriterion("StaffIsDeptManage is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageEqualTo(Boolean value) {
            addCriterion("StaffIsDeptManage =", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageNotEqualTo(Boolean value) {
            addCriterion("StaffIsDeptManage <>", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageGreaterThan(Boolean value) {
            addCriterion("StaffIsDeptManage >", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("StaffIsDeptManage >=", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageLessThan(Boolean value) {
            addCriterion("StaffIsDeptManage <", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageLessThanOrEqualTo(Boolean value) {
            addCriterion("StaffIsDeptManage <=", value, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageIn(List<Boolean> values) {
            addCriterion("StaffIsDeptManage in", values, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageNotIn(List<Boolean> values) {
            addCriterion("StaffIsDeptManage not in", values, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageBetween(Boolean value1, Boolean value2) {
            addCriterion("StaffIsDeptManage between", value1, value2, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffIsDeptManageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("StaffIsDeptManage not between", value1, value2, "staffIsDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNull() {
            addCriterion("StaffPassword is null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNotNull() {
            addCriterion("StaffPassword is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordEqualTo(String value) {
            addCriterion("StaffPassword =", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotEqualTo(String value) {
            addCriterion("StaffPassword <>", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThan(String value) {
            addCriterion("StaffPassword >", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("StaffPassword >=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThan(String value) {
            addCriterion("StaffPassword <", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThanOrEqualTo(String value) {
            addCriterion("StaffPassword <=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLike(String value) {
            addCriterion("StaffPassword like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotLike(String value) {
            addCriterion("StaffPassword not like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIn(List<String> values) {
            addCriterion("StaffPassword in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotIn(List<String> values) {
            addCriterion("StaffPassword not in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordBetween(String value1, String value2) {
            addCriterion("StaffPassword between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotBetween(String value1, String value2) {
            addCriterion("StaffPassword not between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountIsNull() {
            addCriterion("StaffBuyAccount is null");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountIsNotNull() {
            addCriterion("StaffBuyAccount is not null");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountEqualTo(Long value) {
            addCriterion("StaffBuyAccount =", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountNotEqualTo(Long value) {
            addCriterion("StaffBuyAccount <>", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountGreaterThan(Long value) {
            addCriterion("StaffBuyAccount >", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountGreaterThanOrEqualTo(Long value) {
            addCriterion("StaffBuyAccount >=", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountLessThan(Long value) {
            addCriterion("StaffBuyAccount <", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountLessThanOrEqualTo(Long value) {
            addCriterion("StaffBuyAccount <=", value, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountIn(List<Long> values) {
            addCriterion("StaffBuyAccount in", values, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountNotIn(List<Long> values) {
            addCriterion("StaffBuyAccount not in", values, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountBetween(Long value1, Long value2) {
            addCriterion("StaffBuyAccount between", value1, value2, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffBuyAccountNotBetween(Long value1, Long value2) {
            addCriterion("StaffBuyAccount not between", value1, value2, "staffBuyAccount");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundIsNull() {
            addCriterion("StaffFixFund is null");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundIsNotNull() {
            addCriterion("StaffFixFund is not null");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundEqualTo(Long value) {
            addCriterion("StaffFixFund =", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundNotEqualTo(Long value) {
            addCriterion("StaffFixFund <>", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundGreaterThan(Long value) {
            addCriterion("StaffFixFund >", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundGreaterThanOrEqualTo(Long value) {
            addCriterion("StaffFixFund >=", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundLessThan(Long value) {
            addCriterion("StaffFixFund <", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundLessThanOrEqualTo(Long value) {
            addCriterion("StaffFixFund <=", value, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundIn(List<Long> values) {
            addCriterion("StaffFixFund in", values, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundNotIn(List<Long> values) {
            addCriterion("StaffFixFund not in", values, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundBetween(Long value1, Long value2) {
            addCriterion("StaffFixFund between", value1, value2, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffFixFundNotBetween(Long value1, Long value2) {
            addCriterion("StaffFixFund not between", value1, value2, "staffFixFund");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeIsNull() {
            addCriterion("StaffSecondJoinTime is null");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeIsNotNull() {
            addCriterion("StaffSecondJoinTime is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime =", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime <>", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime >", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime >=", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeLessThan(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime <", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondJoinTime <=", value, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeIn(List<Date> values) {
            addCriterionForJDBCDate("StaffSecondJoinTime in", values, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StaffSecondJoinTime not in", values, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffSecondJoinTime between", value1, value2, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondJoinTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffSecondJoinTime not between", value1, value2, "staffSecondJoinTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeIsNull() {
            addCriterion("StaffSecondRetireTime is null");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeIsNotNull() {
            addCriterion("StaffSecondRetireTime is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime =", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime <>", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime >", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime >=", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeLessThan(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime <", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffSecondRetireTime <=", value, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("StaffSecondRetireTime in", values, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StaffSecondRetireTime not in", values, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffSecondRetireTime between", value1, value2, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffSecondRetireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffSecondRetireTime not between", value1, value2, "staffSecondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffDualIsNull() {
            addCriterion("StaffDual is null");
            return (Criteria) this;
        }

        public Criteria andStaffDualIsNotNull() {
            addCriterion("StaffDual is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDualEqualTo(String value) {
            addCriterion("StaffDual =", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotEqualTo(String value) {
            addCriterion("StaffDual <>", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualGreaterThan(String value) {
            addCriterion("StaffDual >", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualGreaterThanOrEqualTo(String value) {
            addCriterion("StaffDual >=", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLessThan(String value) {
            addCriterion("StaffDual <", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLessThanOrEqualTo(String value) {
            addCriterion("StaffDual <=", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLike(String value) {
            addCriterion("StaffDual like", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotLike(String value) {
            addCriterion("StaffDual not like", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualIn(List<String> values) {
            addCriterion("StaffDual in", values, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotIn(List<String> values) {
            addCriterion("StaffDual not in", values, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualBetween(String value1, String value2) {
            addCriterion("StaffDual between", value1, value2, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotBetween(String value1, String value2) {
            addCriterion("StaffDual not between", value1, value2, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffRelationIsNull() {
            addCriterion("StaffRelation is null");
            return (Criteria) this;
        }

        public Criteria andStaffRelationIsNotNull() {
            addCriterion("StaffRelation is not null");
            return (Criteria) this;
        }

        public Criteria andStaffRelationEqualTo(String value) {
            addCriterion("StaffRelation =", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationNotEqualTo(String value) {
            addCriterion("StaffRelation <>", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationGreaterThan(String value) {
            addCriterion("StaffRelation >", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationGreaterThanOrEqualTo(String value) {
            addCriterion("StaffRelation >=", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationLessThan(String value) {
            addCriterion("StaffRelation <", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationLessThanOrEqualTo(String value) {
            addCriterion("StaffRelation <=", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationLike(String value) {
            addCriterion("StaffRelation like", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationNotLike(String value) {
            addCriterion("StaffRelation not like", value, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationIn(List<String> values) {
            addCriterion("StaffRelation in", values, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationNotIn(List<String> values) {
            addCriterion("StaffRelation not in", values, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationBetween(String value1, String value2) {
            addCriterion("StaffRelation between", value1, value2, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffRelationNotBetween(String value1, String value2) {
            addCriterion("StaffRelation not between", value1, value2, "staffRelation");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateIsNull() {
            addCriterion("StaffDiscountRate is null");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateIsNotNull() {
            addCriterion("StaffDiscountRate is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateEqualTo(Double value) {
            addCriterion("StaffDiscountRate =", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateNotEqualTo(Double value) {
            addCriterion("StaffDiscountRate <>", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateGreaterThan(Double value) {
            addCriterion("StaffDiscountRate >", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateGreaterThanOrEqualTo(Double value) {
            addCriterion("StaffDiscountRate >=", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateLessThan(Double value) {
            addCriterion("StaffDiscountRate <", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateLessThanOrEqualTo(Double value) {
            addCriterion("StaffDiscountRate <=", value, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateIn(List<Double> values) {
            addCriterion("StaffDiscountRate in", values, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateNotIn(List<Double> values) {
            addCriterion("StaffDiscountRate not in", values, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateBetween(Double value1, Double value2) {
            addCriterion("StaffDiscountRate between", value1, value2, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffDiscountRateNotBetween(Double value1, Double value2) {
            addCriterion("StaffDiscountRate not between", value1, value2, "staffDiscountRate");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeIsNull() {
            addCriterion("StaffFamilyCode is null");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeIsNotNull() {
            addCriterion("StaffFamilyCode is not null");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeEqualTo(Integer value) {
            addCriterion("StaffFamilyCode =", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeNotEqualTo(Integer value) {
            addCriterion("StaffFamilyCode <>", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeGreaterThan(Integer value) {
            addCriterion("StaffFamilyCode >", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffFamilyCode >=", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeLessThan(Integer value) {
            addCriterion("StaffFamilyCode <", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeLessThanOrEqualTo(Integer value) {
            addCriterion("StaffFamilyCode <=", value, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeIn(List<Integer> values) {
            addCriterion("StaffFamilyCode in", values, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeNotIn(List<Integer> values) {
            addCriterion("StaffFamilyCode not in", values, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeBetween(Integer value1, Integer value2) {
            addCriterion("StaffFamilyCode between", value1, value2, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFamilyCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffFamilyCode not between", value1, value2, "staffFamilyCode");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeIsNull() {
            addCriterion("StaffFirstJobTime is null");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeIsNotNull() {
            addCriterion("StaffFirstJobTime is not null");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeEqualTo(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime =", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime <>", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime >", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime >=", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeLessThan(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime <", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StaffFirstJobTime <=", value, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeIn(List<Date> values) {
            addCriterionForJDBCDate("StaffFirstJobTime in", values, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StaffFirstJobTime not in", values, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffFirstJobTime between", value1, value2, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffFirstJobTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StaffFirstJobTime not between", value1, value2, "staffFirstJobTime");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameIsNull() {
            addCriterion("StaffUserName is null");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameIsNotNull() {
            addCriterion("StaffUserName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameEqualTo(String value) {
            addCriterion("StaffUserName =", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameNotEqualTo(String value) {
            addCriterion("StaffUserName <>", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameGreaterThan(String value) {
            addCriterion("StaffUserName >", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffUserName >=", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameLessThan(String value) {
            addCriterion("StaffUserName <", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameLessThanOrEqualTo(String value) {
            addCriterion("StaffUserName <=", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameLike(String value) {
            addCriterion("StaffUserName like", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameNotLike(String value) {
            addCriterion("StaffUserName not like", value, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameIn(List<String> values) {
            addCriterion("StaffUserName in", values, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameNotIn(List<String> values) {
            addCriterion("StaffUserName not in", values, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameBetween(String value1, String value2) {
            addCriterion("StaffUserName between", value1, value2, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andStaffUserNameNotBetween(String value1, String value2) {
            addCriterion("StaffUserName not between", value1, value2, "staffUserName");
            return (Criteria) this;
        }

        public Criteria andOtherValIsNull() {
            addCriterion("OtherVal is null");
            return (Criteria) this;
        }

        public Criteria andOtherValIsNotNull() {
            addCriterion("OtherVal is not null");
            return (Criteria) this;
        }

        public Criteria andOtherValEqualTo(Double value) {
            addCriterion("OtherVal =", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotEqualTo(Double value) {
            addCriterion("OtherVal <>", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValGreaterThan(Double value) {
            addCriterion("OtherVal >", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValGreaterThanOrEqualTo(Double value) {
            addCriterion("OtherVal >=", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValLessThan(Double value) {
            addCriterion("OtherVal <", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValLessThanOrEqualTo(Double value) {
            addCriterion("OtherVal <=", value, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValIn(List<Double> values) {
            addCriterion("OtherVal in", values, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotIn(List<Double> values) {
            addCriterion("OtherVal not in", values, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValBetween(Double value1, Double value2) {
            addCriterion("OtherVal between", value1, value2, "otherVal");
            return (Criteria) this;
        }

        public Criteria andOtherValNotBetween(Double value1, Double value2) {
            addCriterion("OtherVal not between", value1, value2, "otherVal");
            return (Criteria) this;
        }

        public Criteria andTimeValIsNull() {
            addCriterion("TimeVal is null");
            return (Criteria) this;
        }

        public Criteria andTimeValIsNotNull() {
            addCriterion("TimeVal is not null");
            return (Criteria) this;
        }

        public Criteria andTimeValEqualTo(Double value) {
            addCriterion("TimeVal =", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotEqualTo(Double value) {
            addCriterion("TimeVal <>", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValGreaterThan(Double value) {
            addCriterion("TimeVal >", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValGreaterThanOrEqualTo(Double value) {
            addCriterion("TimeVal >=", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValLessThan(Double value) {
            addCriterion("TimeVal <", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValLessThanOrEqualTo(Double value) {
            addCriterion("TimeVal <=", value, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValIn(List<Double> values) {
            addCriterion("TimeVal in", values, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotIn(List<Double> values) {
            addCriterion("TimeVal not in", values, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValBetween(Double value1, Double value2) {
            addCriterion("TimeVal between", value1, value2, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTimeValNotBetween(Double value1, Double value2) {
            addCriterion("TimeVal not between", value1, value2, "timeVal");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNull() {
            addCriterion("TotalVal is null");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNotNull() {
            addCriterion("TotalVal is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValEqualTo(Double value) {
            addCriterion("TotalVal =", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotEqualTo(Double value) {
            addCriterion("TotalVal <>", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThan(Double value) {
            addCriterion("TotalVal >", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThanOrEqualTo(Double value) {
            addCriterion("TotalVal >=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThan(Double value) {
            addCriterion("TotalVal <", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThanOrEqualTo(Double value) {
            addCriterion("TotalVal <=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValIn(List<Double> values) {
            addCriterion("TotalVal in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotIn(List<Double> values) {
            addCriterion("TotalVal not in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValBetween(Double value1, Double value2) {
            addCriterion("TotalVal between", value1, value2, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotBetween(Double value1, Double value2) {
            addCriterion("TotalVal not between", value1, value2, "totalVal");
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

        public Criteria andHouseTypeIsNull() {
            addCriterion("HouseType is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("HouseType is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(Integer value) {
            addCriterion("HouseType =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(Integer value) {
            addCriterion("HouseType <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(Integer value) {
            addCriterion("HouseType >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseType >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(Integer value) {
            addCriterion("HouseType <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("HouseType <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<Integer> values) {
            addCriterion("HouseType in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<Integer> values) {
            addCriterion("HouseType not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(Integer value1, Integer value2) {
            addCriterion("HouseType between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseType not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIsNull() {
            addCriterion("HouseTypeName is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIsNotNull() {
            addCriterion("HouseTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameEqualTo(String value) {
            addCriterion("HouseTypeName =", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotEqualTo(String value) {
            addCriterion("HouseTypeName <>", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameGreaterThan(String value) {
            addCriterion("HouseTypeName >", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseTypeName >=", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLessThan(String value) {
            addCriterion("HouseTypeName <", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLessThanOrEqualTo(String value) {
            addCriterion("HouseTypeName <=", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLike(String value) {
            addCriterion("HouseTypeName like", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotLike(String value) {
            addCriterion("HouseTypeName not like", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIn(List<String> values) {
            addCriterion("HouseTypeName in", values, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotIn(List<String> values) {
            addCriterion("HouseTypeName not in", values, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameBetween(String value1, String value2) {
            addCriterion("HouseTypeName between", value1, value2, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotBetween(String value1, String value2) {
            addCriterion("HouseTypeName not between", value1, value2, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIsNull() {
            addCriterion("HouseLayout is null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIsNotNull() {
            addCriterion("HouseLayout is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutEqualTo(Integer value) {
            addCriterion("HouseLayout =", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNotEqualTo(Integer value) {
            addCriterion("HouseLayout <>", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutGreaterThan(Integer value) {
            addCriterion("HouseLayout >", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseLayout >=", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutLessThan(Integer value) {
            addCriterion("HouseLayout <", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutLessThanOrEqualTo(Integer value) {
            addCriterion("HouseLayout <=", value, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIn(List<Integer> values) {
            addCriterion("HouseLayout in", values, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNotIn(List<Integer> values) {
            addCriterion("HouseLayout not in", values, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutBetween(Integer value1, Integer value2) {
            addCriterion("HouseLayout between", value1, value2, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseLayout not between", value1, value2, "houseLayout");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIsNull() {
            addCriterion("HouseLayoutName is null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIsNotNull() {
            addCriterion("HouseLayoutName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameEqualTo(String value) {
            addCriterion("HouseLayoutName =", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotEqualTo(String value) {
            addCriterion("HouseLayoutName <>", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameGreaterThan(String value) {
            addCriterion("HouseLayoutName >", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseLayoutName >=", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLessThan(String value) {
            addCriterion("HouseLayoutName <", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLessThanOrEqualTo(String value) {
            addCriterion("HouseLayoutName <=", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLike(String value) {
            addCriterion("HouseLayoutName like", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotLike(String value) {
            addCriterion("HouseLayoutName not like", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIn(List<String> values) {
            addCriterion("HouseLayoutName in", values, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotIn(List<String> values) {
            addCriterion("HouseLayoutName not in", values, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameBetween(String value1, String value2) {
            addCriterion("HouseLayoutName between", value1, value2, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotBetween(String value1, String value2) {
            addCriterion("HouseLayoutName not between", value1, value2, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseStructIsNull() {
            addCriterion("HouseStruct is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructIsNotNull() {
            addCriterion("HouseStruct is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructEqualTo(Integer value) {
            addCriterion("HouseStruct =", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructNotEqualTo(Integer value) {
            addCriterion("HouseStruct <>", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructGreaterThan(Integer value) {
            addCriterion("HouseStruct >", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseStruct >=", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructLessThan(Integer value) {
            addCriterion("HouseStruct <", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructLessThanOrEqualTo(Integer value) {
            addCriterion("HouseStruct <=", value, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructIn(List<Integer> values) {
            addCriterion("HouseStruct in", values, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructNotIn(List<Integer> values) {
            addCriterion("HouseStruct not in", values, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructBetween(Integer value1, Integer value2) {
            addCriterion("HouseStruct between", value1, value2, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseStruct not between", value1, value2, "houseStruct");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIsNull() {
            addCriterion("HouseStructName is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIsNotNull() {
            addCriterion("HouseStructName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameEqualTo(String value) {
            addCriterion("HouseStructName =", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotEqualTo(String value) {
            addCriterion("HouseStructName <>", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameGreaterThan(String value) {
            addCriterion("HouseStructName >", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseStructName >=", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLessThan(String value) {
            addCriterion("HouseStructName <", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLessThanOrEqualTo(String value) {
            addCriterion("HouseStructName <=", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLike(String value) {
            addCriterion("HouseStructName like", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotLike(String value) {
            addCriterion("HouseStructName not like", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIn(List<String> values) {
            addCriterion("HouseStructName in", values, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotIn(List<String> values) {
            addCriterion("HouseStructName not in", values, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameBetween(String value1, String value2) {
            addCriterion("HouseStructName between", value1, value2, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotBetween(String value1, String value2) {
            addCriterion("HouseStructName not between", value1, value2, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNull() {
            addCriterion("HouseStatus is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNotNull() {
            addCriterion("HouseStatus is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusEqualTo(Integer value) {
            addCriterion("HouseStatus =", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotEqualTo(Integer value) {
            addCriterion("HouseStatus <>", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThan(Integer value) {
            addCriterion("HouseStatus >", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseStatus >=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThan(Integer value) {
            addCriterion("HouseStatus <", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("HouseStatus <=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIn(List<Integer> values) {
            addCriterion("HouseStatus in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotIn(List<Integer> values) {
            addCriterion("HouseStatus not in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusBetween(Integer value1, Integer value2) {
            addCriterion("HouseStatus between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseStatus not between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameIsNull() {
            addCriterion("HouseStatusName is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameIsNotNull() {
            addCriterion("HouseStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameEqualTo(String value) {
            addCriterion("HouseStatusName =", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameNotEqualTo(String value) {
            addCriterion("HouseStatusName <>", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameGreaterThan(String value) {
            addCriterion("HouseStatusName >", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseStatusName >=", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameLessThan(String value) {
            addCriterion("HouseStatusName <", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameLessThanOrEqualTo(String value) {
            addCriterion("HouseStatusName <=", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameLike(String value) {
            addCriterion("HouseStatusName like", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameNotLike(String value) {
            addCriterion("HouseStatusName not like", value, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameIn(List<String> values) {
            addCriterion("HouseStatusName in", values, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameNotIn(List<String> values) {
            addCriterion("HouseStatusName not in", values, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameBetween(String value1, String value2) {
            addCriterion("HouseStatusName between", value1, value2, "houseStatusName");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNameNotBetween(String value1, String value2) {
            addCriterion("HouseStatusName not between", value1, value2, "houseStatusName");
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

        public Criteria andHouseUsedAreaIsNull() {
            addCriterion("HouseUsedArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaIsNotNull() {
            addCriterion("HouseUsedArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaEqualTo(Double value) {
            addCriterion("HouseUsedArea =", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotEqualTo(Double value) {
            addCriterion("HouseUsedArea <>", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaGreaterThan(Double value) {
            addCriterion("HouseUsedArea >", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseUsedArea >=", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaLessThan(Double value) {
            addCriterion("HouseUsedArea <", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseUsedArea <=", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaIn(List<Double> values) {
            addCriterion("HouseUsedArea in", values, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotIn(List<Double> values) {
            addCriterion("HouseUsedArea not in", values, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaBetween(Double value1, Double value2) {
            addCriterion("HouseUsedArea between", value1, value2, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseUsedArea not between", value1, value2, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaIsNull() {
            addCriterion("HouseBasementArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaIsNotNull() {
            addCriterion("HouseBasementArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaEqualTo(Double value) {
            addCriterion("HouseBasementArea =", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaNotEqualTo(Double value) {
            addCriterion("HouseBasementArea <>", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaGreaterThan(Double value) {
            addCriterion("HouseBasementArea >", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseBasementArea >=", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaLessThan(Double value) {
            addCriterion("HouseBasementArea <", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseBasementArea <=", value, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaIn(List<Double> values) {
            addCriterion("HouseBasementArea in", values, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaNotIn(List<Double> values) {
            addCriterion("HouseBasementArea not in", values, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaBetween(Double value1, Double value2) {
            addCriterion("HouseBasementArea between", value1, value2, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseBasementAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseBasementArea not between", value1, value2, "houseBasementArea");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNull() {
            addCriterion("HouseAddress is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNotNull() {
            addCriterion("HouseAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressEqualTo(String value) {
            addCriterion("HouseAddress =", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotEqualTo(String value) {
            addCriterion("HouseAddress <>", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThan(String value) {
            addCriterion("HouseAddress >", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("HouseAddress >=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThan(String value) {
            addCriterion("HouseAddress <", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThanOrEqualTo(String value) {
            addCriterion("HouseAddress <=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLike(String value) {
            addCriterion("HouseAddress like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotLike(String value) {
            addCriterion("HouseAddress not like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIn(List<String> values) {
            addCriterion("HouseAddress in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotIn(List<String> values) {
            addCriterion("HouseAddress not in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressBetween(String value1, String value2) {
            addCriterion("HouseAddress between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotBetween(String value1, String value2) {
            addCriterion("HouseAddress not between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("BuildingId is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("BuildingId is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("BuildingId =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("BuildingId <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("BuildingId >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BuildingId >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("BuildingId <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("BuildingId <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("BuildingId in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("BuildingId not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("BuildingId between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BuildingId not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("BuildingName is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("BuildingName is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("BuildingName =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("BuildingName <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("BuildingName >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("BuildingName >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("BuildingName <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("BuildingName <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("BuildingName like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("BuildingName not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("BuildingName in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("BuildingName not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("BuildingName between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("BuildingName not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("RegionId is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("RegionId is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Integer value) {
            addCriterion("RegionId =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Integer value) {
            addCriterion("RegionId <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Integer value) {
            addCriterion("RegionId >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RegionId >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Integer value) {
            addCriterion("RegionId <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("RegionId <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Integer> values) {
            addCriterion("RegionId in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Integer> values) {
            addCriterion("RegionId not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("RegionId between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RegionId not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("RegionName is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("RegionName is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("RegionName =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("RegionName <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("RegionName >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("RegionName >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("RegionName <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("RegionName <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("RegionName like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("RegionName not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("RegionName in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("RegionName not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("RegionName between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("RegionName not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("ProId is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("ProId is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("ProId =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("ProId <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("ProId >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("ProId >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("ProId <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("ProId <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("ProId like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("ProId not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("ProId in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("ProId not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("ProId between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("ProId not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkIsNull() {
            addCriterion("HouseRemark is null");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkIsNotNull() {
            addCriterion("HouseRemark is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkEqualTo(String value) {
            addCriterion("HouseRemark =", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkNotEqualTo(String value) {
            addCriterion("HouseRemark <>", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkGreaterThan(String value) {
            addCriterion("HouseRemark >", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("HouseRemark >=", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkLessThan(String value) {
            addCriterion("HouseRemark <", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkLessThanOrEqualTo(String value) {
            addCriterion("HouseRemark <=", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkLike(String value) {
            addCriterion("HouseRemark like", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkNotLike(String value) {
            addCriterion("HouseRemark not like", value, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkIn(List<String> values) {
            addCriterion("HouseRemark in", values, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkNotIn(List<String> values) {
            addCriterion("HouseRemark not in", values, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkBetween(String value1, String value2) {
            addCriterion("HouseRemark between", value1, value2, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseRemarkNotBetween(String value1, String value2) {
            addCriterion("HouseRemark not between", value1, value2, "houseRemark");
            return (Criteria) this;
        }

        public Criteria andHouseImageIsNull() {
            addCriterion("HouseImage is null");
            return (Criteria) this;
        }

        public Criteria andHouseImageIsNotNull() {
            addCriterion("HouseImage is not null");
            return (Criteria) this;
        }

        public Criteria andHouseImageEqualTo(String value) {
            addCriterion("HouseImage =", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotEqualTo(String value) {
            addCriterion("HouseImage <>", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageGreaterThan(String value) {
            addCriterion("HouseImage >", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageGreaterThanOrEqualTo(String value) {
            addCriterion("HouseImage >=", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLessThan(String value) {
            addCriterion("HouseImage <", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLessThanOrEqualTo(String value) {
            addCriterion("HouseImage <=", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageLike(String value) {
            addCriterion("HouseImage like", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotLike(String value) {
            addCriterion("HouseImage not like", value, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageIn(List<String> values) {
            addCriterion("HouseImage in", values, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotIn(List<String> values) {
            addCriterion("HouseImage not in", values, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageBetween(String value1, String value2) {
            addCriterion("HouseImage between", value1, value2, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseImageNotBetween(String value1, String value2) {
            addCriterion("HouseImage not between", value1, value2, "houseImage");
            return (Criteria) this;
        }

        public Criteria andHouseRentalIsNull() {
            addCriterion("HouseRental is null");
            return (Criteria) this;
        }

        public Criteria andHouseRentalIsNotNull() {
            addCriterion("HouseRental is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRentalEqualTo(Double value) {
            addCriterion("HouseRental =", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalNotEqualTo(Double value) {
            addCriterion("HouseRental <>", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalGreaterThan(Double value) {
            addCriterion("HouseRental >", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseRental >=", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalLessThan(Double value) {
            addCriterion("HouseRental <", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalLessThanOrEqualTo(Double value) {
            addCriterion("HouseRental <=", value, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalIn(List<Double> values) {
            addCriterion("HouseRental in", values, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalNotIn(List<Double> values) {
            addCriterion("HouseRental not in", values, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalBetween(Double value1, Double value2) {
            addCriterion("HouseRental between", value1, value2, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseRentalNotBetween(Double value1, Double value2) {
            addCriterion("HouseRental not between", value1, value2, "houseRental");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeIsNull() {
            addCriterion("HouseFinishTime is null");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeIsNotNull() {
            addCriterion("HouseFinishTime is not null");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("HouseFinishTime =", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("HouseFinishTime <>", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("HouseFinishTime >", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HouseFinishTime >=", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("HouseFinishTime <", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HouseFinishTime <=", value, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("HouseFinishTime in", values, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("HouseFinishTime not in", values, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HouseFinishTime between", value1, value2, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HouseFinishTime not between", value1, value2, "houseFinishTime");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusIsNull() {
            addCriterion("HouseRecordStatus is null");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusIsNotNull() {
            addCriterion("HouseRecordStatus is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusEqualTo(Integer value) {
            addCriterion("HouseRecordStatus =", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusNotEqualTo(Integer value) {
            addCriterion("HouseRecordStatus <>", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusGreaterThan(Integer value) {
            addCriterion("HouseRecordStatus >", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseRecordStatus >=", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusLessThan(Integer value) {
            addCriterion("HouseRecordStatus <", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("HouseRecordStatus <=", value, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusIn(List<Integer> values) {
            addCriterion("HouseRecordStatus in", values, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusNotIn(List<Integer> values) {
            addCriterion("HouseRecordStatus not in", values, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("HouseRecordStatus between", value1, value2, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andHouseRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseRecordStatus not between", value1, value2, "houseRecordStatus");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIsNull() {
            addCriterion("LastRentTime is null");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIsNotNull() {
            addCriterion("LastRentTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeEqualTo(Date value) {
            addCriterion("LastRentTime =", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotEqualTo(Date value) {
            addCriterion("LastRentTime <>", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeGreaterThan(Date value) {
            addCriterion("LastRentTime >", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastRentTime >=", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeLessThan(Date value) {
            addCriterion("LastRentTime <", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeLessThanOrEqualTo(Date value) {
            addCriterion("LastRentTime <=", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIn(List<Date> values) {
            addCriterion("LastRentTime in", values, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotIn(List<Date> values) {
            addCriterion("LastRentTime not in", values, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeBetween(Date value1, Date value2) {
            addCriterion("LastRentTime between", value1, value2, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotBetween(Date value1, Date value2) {
            addCriterion("LastRentTime not between", value1, value2, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PayType is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PayType is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("PayType =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("PayType <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("PayType >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PayType >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("PayType <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PayType <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("PayType in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("PayType not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PayType between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PayType not between", value1, value2, "payType");
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