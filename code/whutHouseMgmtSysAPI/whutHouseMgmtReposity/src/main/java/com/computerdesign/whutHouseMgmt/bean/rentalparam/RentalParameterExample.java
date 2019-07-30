package com.computerdesign.whutHouseMgmt.bean.rentalparam;

import java.util.ArrayList;
import java.util.List;

public class RentalParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentalParameterExample() {
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

        public Criteria andRentalParamIdIsNull() {
            addCriterion("RentalParamId is null");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdIsNotNull() {
            addCriterion("RentalParamId is not null");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdEqualTo(Integer value) {
            addCriterion("RentalParamId =", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdNotEqualTo(Integer value) {
            addCriterion("RentalParamId <>", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdGreaterThan(Integer value) {
            addCriterion("RentalParamId >", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentalParamId >=", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdLessThan(Integer value) {
            addCriterion("RentalParamId <", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("RentalParamId <=", value, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdIn(List<Integer> values) {
            addCriterion("RentalParamId in", values, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdNotIn(List<Integer> values) {
            addCriterion("RentalParamId not in", values, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdBetween(Integer value1, Integer value2) {
            addCriterion("RentalParamId between", value1, value2, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RentalParamId not between", value1, value2, "rentalParamId");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivIsNull() {
            addCriterion("RentalTimeDiv is null");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivIsNotNull() {
            addCriterion("RentalTimeDiv is not null");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivEqualTo(Integer value) {
            addCriterion("RentalTimeDiv =", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivNotEqualTo(Integer value) {
            addCriterion("RentalTimeDiv <>", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivGreaterThan(Integer value) {
            addCriterion("RentalTimeDiv >", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentalTimeDiv >=", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivLessThan(Integer value) {
            addCriterion("RentalTimeDiv <", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivLessThanOrEqualTo(Integer value) {
            addCriterion("RentalTimeDiv <=", value, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivIn(List<Integer> values) {
            addCriterion("RentalTimeDiv in", values, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivNotIn(List<Integer> values) {
            addCriterion("RentalTimeDiv not in", values, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivBetween(Integer value1, Integer value2) {
            addCriterion("RentalTimeDiv between", value1, value2, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalTimeDivNotBetween(Integer value1, Integer value2) {
            addCriterion("RentalTimeDiv not between", value1, value2, "rentalTimeDiv");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctIsNull() {
            addCriterion("RentalOldDct is null");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctIsNotNull() {
            addCriterion("RentalOldDct is not null");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctEqualTo(String value) {
            addCriterion("RentalOldDct =", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctNotEqualTo(String value) {
            addCriterion("RentalOldDct <>", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctGreaterThan(String value) {
            addCriterion("RentalOldDct >", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctGreaterThanOrEqualTo(String value) {
            addCriterion("RentalOldDct >=", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctLessThan(String value) {
            addCriterion("RentalOldDct <", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctLessThanOrEqualTo(String value) {
            addCriterion("RentalOldDct <=", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctLike(String value) {
            addCriterion("RentalOldDct like", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctNotLike(String value) {
            addCriterion("RentalOldDct not like", value, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctIn(List<String> values) {
            addCriterion("RentalOldDct in", values, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctNotIn(List<String> values) {
            addCriterion("RentalOldDct not in", values, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctBetween(String value1, String value2) {
            addCriterion("RentalOldDct between", value1, value2, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalOldDctNotBetween(String value1, String value2) {
            addCriterion("RentalOldDct not between", value1, value2, "rentalOldDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearIsNull() {
            addCriterion("RentalNewDctYear is null");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearIsNotNull() {
            addCriterion("RentalNewDctYear is not null");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearEqualTo(Integer value) {
            addCriterion("RentalNewDctYear =", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearNotEqualTo(Integer value) {
            addCriterion("RentalNewDctYear <>", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearGreaterThan(Integer value) {
            addCriterion("RentalNewDctYear >", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentalNewDctYear >=", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearLessThan(Integer value) {
            addCriterion("RentalNewDctYear <", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearLessThanOrEqualTo(Integer value) {
            addCriterion("RentalNewDctYear <=", value, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearIn(List<Integer> values) {
            addCriterion("RentalNewDctYear in", values, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearNotIn(List<Integer> values) {
            addCriterion("RentalNewDctYear not in", values, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearBetween(Integer value1, Integer value2) {
            addCriterion("RentalNewDctYear between", value1, value2, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctYearNotBetween(Integer value1, Integer value2) {
            addCriterion("RentalNewDctYear not between", value1, value2, "rentalNewDctYear");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctIsNull() {
            addCriterion("RentalNewDct is null");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctIsNotNull() {
            addCriterion("RentalNewDct is not null");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctEqualTo(String value) {
            addCriterion("RentalNewDct =", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctNotEqualTo(String value) {
            addCriterion("RentalNewDct <>", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctGreaterThan(String value) {
            addCriterion("RentalNewDct >", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctGreaterThanOrEqualTo(String value) {
            addCriterion("RentalNewDct >=", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctLessThan(String value) {
            addCriterion("RentalNewDct <", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctLessThanOrEqualTo(String value) {
            addCriterion("RentalNewDct <=", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctLike(String value) {
            addCriterion("RentalNewDct like", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctNotLike(String value) {
            addCriterion("RentalNewDct not like", value, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctIn(List<String> values) {
            addCriterion("RentalNewDct in", values, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctNotIn(List<String> values) {
            addCriterion("RentalNewDct not in", values, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctBetween(String value1, String value2) {
            addCriterion("RentalNewDct between", value1, value2, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andRentalNewDctNotBetween(String value1, String value2) {
            addCriterion("RentalNewDct not between", value1, value2, "rentalNewDct");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdIsNull() {
            addCriterion("ParamTypeId is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdIsNotNull() {
            addCriterion("ParamTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdEqualTo(Integer value) {
            addCriterion("ParamTypeId =", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdNotEqualTo(Integer value) {
            addCriterion("ParamTypeId <>", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdGreaterThan(Integer value) {
            addCriterion("ParamTypeId >", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParamTypeId >=", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdLessThan(Integer value) {
            addCriterion("ParamTypeId <", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("ParamTypeId <=", value, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdIn(List<Integer> values) {
            addCriterion("ParamTypeId in", values, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdNotIn(List<Integer> values) {
            addCriterion("ParamTypeId not in", values, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("ParamTypeId between", value1, value2, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ParamTypeId not between", value1, value2, "paramTypeId");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameIsNull() {
            addCriterion("ParamTypeName is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameIsNotNull() {
            addCriterion("ParamTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameEqualTo(String value) {
            addCriterion("ParamTypeName =", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameNotEqualTo(String value) {
            addCriterion("ParamTypeName <>", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameGreaterThan(String value) {
            addCriterion("ParamTypeName >", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ParamTypeName >=", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameLessThan(String value) {
            addCriterion("ParamTypeName <", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameLessThanOrEqualTo(String value) {
            addCriterion("ParamTypeName <=", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameLike(String value) {
            addCriterion("ParamTypeName like", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameNotLike(String value) {
            addCriterion("ParamTypeName not like", value, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameIn(List<String> values) {
            addCriterion("ParamTypeName in", values, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameNotIn(List<String> values) {
            addCriterion("ParamTypeName not in", values, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameBetween(String value1, String value2) {
            addCriterion("ParamTypeName between", value1, value2, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andParamTypeNameNotBetween(String value1, String value2) {
            addCriterion("ParamTypeName not between", value1, value2, "paramTypeName");
            return (Criteria) this;
        }

        public Criteria andRentUpRateIsNull() {
            addCriterion("RentUpRate is null");
            return (Criteria) this;
        }

        public Criteria andRentUpRateIsNotNull() {
            addCriterion("RentUpRate is not null");
            return (Criteria) this;
        }

        public Criteria andRentUpRateEqualTo(String value) {
            addCriterion("RentUpRate =", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateNotEqualTo(String value) {
            addCriterion("RentUpRate <>", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateGreaterThan(String value) {
            addCriterion("RentUpRate >", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateGreaterThanOrEqualTo(String value) {
            addCriterion("RentUpRate >=", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateLessThan(String value) {
            addCriterion("RentUpRate <", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateLessThanOrEqualTo(String value) {
            addCriterion("RentUpRate <=", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateLike(String value) {
            addCriterion("RentUpRate like", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateNotLike(String value) {
            addCriterion("RentUpRate not like", value, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateIn(List<String> values) {
            addCriterion("RentUpRate in", values, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateNotIn(List<String> values) {
            addCriterion("RentUpRate not in", values, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateBetween(String value1, String value2) {
            addCriterion("RentUpRate between", value1, value2, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andRentUpRateNotBetween(String value1, String value2) {
            addCriterion("RentUpRate not between", value1, value2, "rentUpRate");
            return (Criteria) this;
        }

        public Criteria andLimitYearIsNull() {
            addCriterion("LimitYear is null");
            return (Criteria) this;
        }

        public Criteria andLimitYearIsNotNull() {
            addCriterion("LimitYear is not null");
            return (Criteria) this;
        }

        public Criteria andLimitYearEqualTo(Integer value) {
            addCriterion("LimitYear =", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotEqualTo(Integer value) {
            addCriterion("LimitYear <>", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearGreaterThan(Integer value) {
            addCriterion("LimitYear >", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("LimitYear >=", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearLessThan(Integer value) {
            addCriterion("LimitYear <", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearLessThanOrEqualTo(Integer value) {
            addCriterion("LimitYear <=", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearIn(List<Integer> values) {
            addCriterion("LimitYear in", values, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotIn(List<Integer> values) {
            addCriterion("LimitYear not in", values, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearBetween(Integer value1, Integer value2) {
            addCriterion("LimitYear between", value1, value2, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotBetween(Integer value1, Integer value2) {
            addCriterion("LimitYear not between", value1, value2, "limitYear");
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