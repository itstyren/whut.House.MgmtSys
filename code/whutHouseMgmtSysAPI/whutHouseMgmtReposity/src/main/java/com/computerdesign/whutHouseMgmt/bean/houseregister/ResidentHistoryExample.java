package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResidentHistoryExample() {
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

        public Criteria andHouseRelationIsNull() {
            addCriterion("HouseRelation is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelationIsNotNull() {
            addCriterion("HouseRelation is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelationEqualTo(Integer value) {
            addCriterion("HouseRelation =", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationNotEqualTo(Integer value) {
            addCriterion("HouseRelation <>", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationGreaterThan(Integer value) {
            addCriterion("HouseRelation >", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseRelation >=", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationLessThan(Integer value) {
            addCriterion("HouseRelation <", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationLessThanOrEqualTo(Integer value) {
            addCriterion("HouseRelation <=", value, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationIn(List<Integer> values) {
            addCriterion("HouseRelation in", values, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationNotIn(List<Integer> values) {
            addCriterion("HouseRelation not in", values, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationBetween(Integer value1, Integer value2) {
            addCriterion("HouseRelation between", value1, value2, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andHouseRelationNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseRelation not between", value1, value2, "houseRelation");
            return (Criteria) this;
        }

        public Criteria andIsBookIsNull() {
            addCriterion("IsBook is null");
            return (Criteria) this;
        }

        public Criteria andIsBookIsNotNull() {
            addCriterion("IsBook is not null");
            return (Criteria) this;
        }

        public Criteria andIsBookEqualTo(Boolean value) {
            addCriterion("IsBook =", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookNotEqualTo(Boolean value) {
            addCriterion("IsBook <>", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookGreaterThan(Boolean value) {
            addCriterion("IsBook >", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsBook >=", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookLessThan(Boolean value) {
            addCriterion("IsBook <", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookLessThanOrEqualTo(Boolean value) {
            addCriterion("IsBook <=", value, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookIn(List<Boolean> values) {
            addCriterion("IsBook in", values, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookNotIn(List<Boolean> values) {
            addCriterion("IsBook not in", values, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookBetween(Boolean value1, Boolean value2) {
            addCriterion("IsBook between", value1, value2, "isBook");
            return (Criteria) this;
        }

        public Criteria andIsBookNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsBook not between", value1, value2, "isBook");
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

        public Criteria andSysTimeIsNull() {
            addCriterion("SysTime is null");
            return (Criteria) this;
        }

        public Criteria andSysTimeIsNotNull() {
            addCriterion("SysTime is not null");
            return (Criteria) this;
        }

        public Criteria andSysTimeEqualTo(Date value) {
            addCriterion("SysTime =", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotEqualTo(Date value) {
            addCriterion("SysTime <>", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeGreaterThan(Date value) {
            addCriterion("SysTime >", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SysTime >=", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeLessThan(Date value) {
            addCriterion("SysTime <", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeLessThanOrEqualTo(Date value) {
            addCriterion("SysTime <=", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeIn(List<Date> values) {
            addCriterion("SysTime in", values, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotIn(List<Date> values) {
            addCriterion("SysTime not in", values, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeBetween(Date value1, Date value2) {
            addCriterion("SysTime between", value1, value2, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotBetween(Date value1, Date value2) {
            addCriterion("SysTime not between", value1, value2, "sysTime");
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