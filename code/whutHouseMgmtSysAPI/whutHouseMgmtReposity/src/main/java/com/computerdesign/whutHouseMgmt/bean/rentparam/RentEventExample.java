package com.computerdesign.whutHouseMgmt.bean.rentparam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentEventExample() {
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

        public Criteria andRentEventIdIsNull() {
            addCriterion("RentEventId is null");
            return (Criteria) this;
        }

        public Criteria andRentEventIdIsNotNull() {
            addCriterion("RentEventId is not null");
            return (Criteria) this;
        }

        public Criteria andRentEventIdEqualTo(Integer value) {
            addCriterion("RentEventId =", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotEqualTo(Integer value) {
            addCriterion("RentEventId <>", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdGreaterThan(Integer value) {
            addCriterion("RentEventId >", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentEventId >=", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdLessThan(Integer value) {
            addCriterion("RentEventId <", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdLessThanOrEqualTo(Integer value) {
            addCriterion("RentEventId <=", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdIn(List<Integer> values) {
            addCriterion("RentEventId in", values, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotIn(List<Integer> values) {
            addCriterion("RentEventId not in", values, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdBetween(Integer value1, Integer value2) {
            addCriterion("RentEventId between", value1, value2, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RentEventId not between", value1, value2, "rentEventId");
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

        public Criteria andRentIsOpenSelIsNull() {
            addCriterion("RentIsOpenSel is null");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelIsNotNull() {
            addCriterion("RentIsOpenSel is not null");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelEqualTo(Boolean value) {
            addCriterion("RentIsOpenSel =", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotEqualTo(Boolean value) {
            addCriterion("RentIsOpenSel <>", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelGreaterThan(Boolean value) {
            addCriterion("RentIsOpenSel >", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("RentIsOpenSel >=", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelLessThan(Boolean value) {
            addCriterion("RentIsOpenSel <", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelLessThanOrEqualTo(Boolean value) {
            addCriterion("RentIsOpenSel <=", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelIn(List<Boolean> values) {
            addCriterion("RentIsOpenSel in", values, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotIn(List<Boolean> values) {
            addCriterion("RentIsOpenSel not in", values, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelBetween(Boolean value1, Boolean value2) {
            addCriterion("RentIsOpenSel between", value1, value2, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("RentIsOpenSel not between", value1, value2, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIsNull() {
            addCriterion("RentTimeBegin is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIsNotNull() {
            addCriterion("RentTimeBegin is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginEqualTo(Date value) {
            addCriterion("RentTimeBegin =", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotEqualTo(Date value) {
            addCriterion("RentTimeBegin <>", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginGreaterThan(Date value) {
            addCriterion("RentTimeBegin >", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("RentTimeBegin >=", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginLessThan(Date value) {
            addCriterion("RentTimeBegin <", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginLessThanOrEqualTo(Date value) {
            addCriterion("RentTimeBegin <=", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIn(List<Date> values) {
            addCriterion("RentTimeBegin in", values, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotIn(List<Date> values) {
            addCriterion("RentTimeBegin not in", values, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginBetween(Date value1, Date value2) {
            addCriterion("RentTimeBegin between", value1, value2, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotBetween(Date value1, Date value2) {
            addCriterion("RentTimeBegin not between", value1, value2, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIsNull() {
            addCriterion("RentTimeRanges is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIsNotNull() {
            addCriterion("RentTimeRanges is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesEqualTo(Integer value) {
            addCriterion("RentTimeRanges =", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotEqualTo(Integer value) {
            addCriterion("RentTimeRanges <>", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesGreaterThan(Integer value) {
            addCriterion("RentTimeRanges >", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RentTimeRanges >=", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesLessThan(Integer value) {
            addCriterion("RentTimeRanges <", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesLessThanOrEqualTo(Integer value) {
            addCriterion("RentTimeRanges <=", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIn(List<Integer> values) {
            addCriterion("RentTimeRanges in", values, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotIn(List<Integer> values) {
            addCriterion("RentTimeRanges not in", values, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesBetween(Integer value1, Integer value2) {
            addCriterion("RentTimeRanges between", value1, value2, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotBetween(Integer value1, Integer value2) {
            addCriterion("RentTimeRanges not between", value1, value2, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeIsNull() {
            addCriterion("daySelectTimeRange is null");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeIsNotNull() {
            addCriterion("daySelectTimeRange is not null");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeEqualTo(String value) {
            addCriterion("daySelectTimeRange =", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeNotEqualTo(String value) {
            addCriterion("daySelectTimeRange <>", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeGreaterThan(String value) {
            addCriterion("daySelectTimeRange >", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeGreaterThanOrEqualTo(String value) {
            addCriterion("daySelectTimeRange >=", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeLessThan(String value) {
            addCriterion("daySelectTimeRange <", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeLessThanOrEqualTo(String value) {
            addCriterion("daySelectTimeRange <=", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeLike(String value) {
            addCriterion("daySelectTimeRange like", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeNotLike(String value) {
            addCriterion("daySelectTimeRange not like", value, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeIn(List<String> values) {
            addCriterion("daySelectTimeRange in", values, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeNotIn(List<String> values) {
            addCriterion("daySelectTimeRange not in", values, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeBetween(String value1, String value2) {
            addCriterion("daySelectTimeRange between", value1, value2, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andDaySelectTimeRangeNotBetween(String value1, String value2) {
            addCriterion("daySelectTimeRange not between", value1, value2, "daySelectTimeRange");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIsNull() {
            addCriterion("RentSelValReq is null");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIsNotNull() {
            addCriterion("RentSelValReq is not null");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqEqualTo(String value) {
            addCriterion("RentSelValReq =", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotEqualTo(String value) {
            addCriterion("RentSelValReq <>", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqGreaterThan(String value) {
            addCriterion("RentSelValReq >", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqGreaterThanOrEqualTo(String value) {
            addCriterion("RentSelValReq >=", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLessThan(String value) {
            addCriterion("RentSelValReq <", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLessThanOrEqualTo(String value) {
            addCriterion("RentSelValReq <=", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLike(String value) {
            addCriterion("RentSelValReq like", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotLike(String value) {
            addCriterion("RentSelValReq not like", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIn(List<String> values) {
            addCriterion("RentSelValReq in", values, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotIn(List<String> values) {
            addCriterion("RentSelValReq not in", values, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqBetween(String value1, String value2) {
            addCriterion("RentSelValReq between", value1, value2, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotBetween(String value1, String value2) {
            addCriterion("RentSelValReq not between", value1, value2, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIsNull() {
            addCriterion("RentSelRules is null");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIsNotNull() {
            addCriterion("RentSelRules is not null");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesEqualTo(String value) {
            addCriterion("RentSelRules =", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotEqualTo(String value) {
            addCriterion("RentSelRules <>", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesGreaterThan(String value) {
            addCriterion("RentSelRules >", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesGreaterThanOrEqualTo(String value) {
            addCriterion("RentSelRules >=", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLessThan(String value) {
            addCriterion("RentSelRules <", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLessThanOrEqualTo(String value) {
            addCriterion("RentSelRules <=", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLike(String value) {
            addCriterion("RentSelRules like", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotLike(String value) {
            addCriterion("RentSelRules not like", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIn(List<String> values) {
            addCriterion("RentSelRules in", values, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotIn(List<String> values) {
            addCriterion("RentSelRules not in", values, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesBetween(String value1, String value2) {
            addCriterion("RentSelRules between", value1, value2, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotBetween(String value1, String value2) {
            addCriterion("RentSelRules not between", value1, value2, "rentSelRules");
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