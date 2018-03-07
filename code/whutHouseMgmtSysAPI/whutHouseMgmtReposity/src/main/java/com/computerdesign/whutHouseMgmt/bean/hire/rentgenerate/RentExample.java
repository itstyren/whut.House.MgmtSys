package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentExample() {
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

        public Criteria andIsGetIsNull() {
            addCriterion("IsGet is null");
            return (Criteria) this;
        }

        public Criteria andIsGetIsNotNull() {
            addCriterion("IsGet is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetEqualTo(Byte value) {
            addCriterion("IsGet =", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetNotEqualTo(Byte value) {
            addCriterion("IsGet <>", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetGreaterThan(Byte value) {
            addCriterion("IsGet >", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetGreaterThanOrEqualTo(Byte value) {
            addCriterion("IsGet >=", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetLessThan(Byte value) {
            addCriterion("IsGet <", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetLessThanOrEqualTo(Byte value) {
            addCriterion("IsGet <=", value, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetIn(List<Byte> values) {
            addCriterion("IsGet in", values, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetNotIn(List<Byte> values) {
            addCriterion("IsGet not in", values, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetBetween(Byte value1, Byte value2) {
            addCriterion("IsGet between", value1, value2, "isGet");
            return (Criteria) this;
        }

        public Criteria andIsGetNotBetween(Byte value1, Byte value2) {
            addCriterion("IsGet not between", value1, value2, "isGet");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BeginTime is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BeginTime is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BeginTime =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BeginTime <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BeginTime >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BeginTime >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BeginTime <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BeginTime <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BeginTime in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BeginTime not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BeginTime between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BeginTime not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("EndTime =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("EndTime <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("EndTime >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EndTime >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("EndTime <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("EndTime <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("EndTime in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("EndTime not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("EndTime between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("EndTime not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateIsNull() {
            addCriterion("EmploymentDate is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateIsNotNull() {
            addCriterion("EmploymentDate is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateEqualTo(Date value) {
            addCriterion("EmploymentDate =", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateNotEqualTo(Date value) {
            addCriterion("EmploymentDate <>", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateGreaterThan(Date value) {
            addCriterion("EmploymentDate >", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EmploymentDate >=", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateLessThan(Date value) {
            addCriterion("EmploymentDate <", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateLessThanOrEqualTo(Date value) {
            addCriterion("EmploymentDate <=", value, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateIn(List<Date> values) {
            addCriterion("EmploymentDate in", values, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateNotIn(List<Date> values) {
            addCriterion("EmploymentDate not in", values, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateBetween(Date value1, Date value2) {
            addCriterion("EmploymentDate between", value1, value2, "employmentDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentDateNotBetween(Date value1, Date value2) {
            addCriterion("EmploymentDate not between", value1, value2, "employmentDate");
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

        public Criteria andDiscountRateIsNull() {
            addCriterion("DiscountRate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("DiscountRate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(String value) {
            addCriterion("DiscountRate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(String value) {
            addCriterion("DiscountRate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(String value) {
            addCriterion("DiscountRate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(String value) {
            addCriterion("DiscountRate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(String value) {
            addCriterion("DiscountRate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(String value) {
            addCriterion("DiscountRate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLike(String value) {
            addCriterion("DiscountRate like", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotLike(String value) {
            addCriterion("DiscountRate not like", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<String> values) {
            addCriterion("DiscountRate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<String> values) {
            addCriterion("DiscountRate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(String value1, String value2) {
            addCriterion("DiscountRate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(String value1, String value2) {
            addCriterion("DiscountRate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andInitMoneyIsNull() {
            addCriterion("InitMoney is null");
            return (Criteria) this;
        }

        public Criteria andInitMoneyIsNotNull() {
            addCriterion("InitMoney is not null");
            return (Criteria) this;
        }

        public Criteria andInitMoneyEqualTo(Double value) {
            addCriterion("InitMoney =", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyNotEqualTo(Double value) {
            addCriterion("InitMoney <>", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyGreaterThan(Double value) {
            addCriterion("InitMoney >", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("InitMoney >=", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyLessThan(Double value) {
            addCriterion("InitMoney <", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyLessThanOrEqualTo(Double value) {
            addCriterion("InitMoney <=", value, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyIn(List<Double> values) {
            addCriterion("InitMoney in", values, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyNotIn(List<Double> values) {
            addCriterion("InitMoney not in", values, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyBetween(Double value1, Double value2) {
            addCriterion("InitMoney between", value1, value2, "initMoney");
            return (Criteria) this;
        }

        public Criteria andInitMoneyNotBetween(Double value1, Double value2) {
            addCriterion("InitMoney not between", value1, value2, "initMoney");
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