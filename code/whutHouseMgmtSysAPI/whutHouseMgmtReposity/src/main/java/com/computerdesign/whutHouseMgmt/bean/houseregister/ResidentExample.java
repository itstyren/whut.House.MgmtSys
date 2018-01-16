package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResidentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResidentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
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

        public Criteria andBookTimeIsNull() {
            addCriterion("BookTime is null");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNotNull() {
            addCriterion("BookTime is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimeEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BookTime >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterionForJDBCDate("BookTime <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterionForJDBCDate("BookTime in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BookTime not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookTime between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookTime not between", value1, value2, "bookTime");
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
            addCriterionForJDBCDate("ExpireTime =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ExpireTime >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterionForJDBCDate("ExpireTime <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ExpireTime in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ExpireTime not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpireTime between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpireTime not between", value1, value2, "expireTime");
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

        public Criteria andLastRentTypeIsNull() {
            addCriterion("LastRentType is null");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeIsNotNull() {
            addCriterion("LastRentType is not null");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeEqualTo(String value) {
            addCriterion("LastRentType =", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotEqualTo(String value) {
            addCriterion("LastRentType <>", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeGreaterThan(String value) {
            addCriterion("LastRentType >", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LastRentType >=", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLessThan(String value) {
            addCriterion("LastRentType <", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLessThanOrEqualTo(String value) {
            addCriterion("LastRentType <=", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLike(String value) {
            addCriterion("LastRentType like", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotLike(String value) {
            addCriterion("LastRentType not like", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeIn(List<String> values) {
            addCriterion("LastRentType in", values, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotIn(List<String> values) {
            addCriterion("LastRentType not in", values, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeBetween(String value1, String value2) {
            addCriterion("LastRentType between", value1, value2, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotBetween(String value1, String value2) {
            addCriterion("LastRentType not between", value1, value2, "lastRentType");
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