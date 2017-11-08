package com.computerdesign.whutHouseMgmt.bean.rentparam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

        public Criteria andRentEventIdIsNull() {
            addCriterion("rentEventId is null");
            return (Criteria) this;
        }

        public Criteria andRentEventIdIsNotNull() {
            addCriterion("rentEventId is not null");
            return (Criteria) this;
        }

        public Criteria andRentEventIdEqualTo(Integer value) {
            addCriterion("rentEventId =", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotEqualTo(Integer value) {
            addCriterion("rentEventId <>", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdGreaterThan(Integer value) {
            addCriterion("rentEventId >", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rentEventId >=", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdLessThan(Integer value) {
            addCriterion("rentEventId <", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdLessThanOrEqualTo(Integer value) {
            addCriterion("rentEventId <=", value, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdIn(List<Integer> values) {
            addCriterion("rentEventId in", values, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotIn(List<Integer> values) {
            addCriterion("rentEventId not in", values, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdBetween(Integer value1, Integer value2) {
            addCriterion("rentEventId between", value1, value2, "rentEventId");
            return (Criteria) this;
        }

        public Criteria andRentEventIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rentEventId not between", value1, value2, "rentEventId");
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
            addCriterion("rentIsOpenSel is null");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelIsNotNull() {
            addCriterion("rentIsOpenSel is not null");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelEqualTo(Boolean value) {
            addCriterion("rentIsOpenSel =", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotEqualTo(Boolean value) {
            addCriterion("rentIsOpenSel <>", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelGreaterThan(Boolean value) {
            addCriterion("rentIsOpenSel >", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rentIsOpenSel >=", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelLessThan(Boolean value) {
            addCriterion("rentIsOpenSel <", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelLessThanOrEqualTo(Boolean value) {
            addCriterion("rentIsOpenSel <=", value, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelIn(List<Boolean> values) {
            addCriterion("rentIsOpenSel in", values, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotIn(List<Boolean> values) {
            addCriterion("rentIsOpenSel not in", values, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelBetween(Boolean value1, Boolean value2) {
            addCriterion("rentIsOpenSel between", value1, value2, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentIsOpenSelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rentIsOpenSel not between", value1, value2, "rentIsOpenSel");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIsNull() {
            addCriterion("rentTimeBegin is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIsNotNull() {
            addCriterion("rentTimeBegin is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeBegin =", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeBegin <>", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginGreaterThan(Date value) {
            addCriterionForJDBCDate("rentTimeBegin >", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeBegin >=", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginLessThan(Date value) {
            addCriterionForJDBCDate("rentTimeBegin <", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeBegin <=", value, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginIn(List<Date> values) {
            addCriterionForJDBCDate("rentTimeBegin in", values, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotIn(List<Date> values) {
            addCriterionForJDBCDate("rentTimeBegin not in", values, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rentTimeBegin between", value1, value2, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeBeginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rentTimeBegin not between", value1, value2, "rentTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIsNull() {
            addCriterion("rentTimeRanges is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIsNotNull() {
            addCriterion("rentTimeRanges is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeRanges =", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeRanges <>", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesGreaterThan(Date value) {
            addCriterionForJDBCDate("rentTimeRanges >", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeRanges >=", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesLessThan(Date value) {
            addCriterionForJDBCDate("rentTimeRanges <", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rentTimeRanges <=", value, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesIn(List<Date> values) {
            addCriterionForJDBCDate("rentTimeRanges in", values, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotIn(List<Date> values) {
            addCriterionForJDBCDate("rentTimeRanges not in", values, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rentTimeRanges between", value1, value2, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentTimeRangesNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rentTimeRanges not between", value1, value2, "rentTimeRanges");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIsNull() {
            addCriterion("rentSelValReq is null");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIsNotNull() {
            addCriterion("rentSelValReq is not null");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqEqualTo(String value) {
            addCriterion("rentSelValReq =", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotEqualTo(String value) {
            addCriterion("rentSelValReq <>", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqGreaterThan(String value) {
            addCriterion("rentSelValReq >", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqGreaterThanOrEqualTo(String value) {
            addCriterion("rentSelValReq >=", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLessThan(String value) {
            addCriterion("rentSelValReq <", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLessThanOrEqualTo(String value) {
            addCriterion("rentSelValReq <=", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqLike(String value) {
            addCriterion("rentSelValReq like", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotLike(String value) {
            addCriterion("rentSelValReq not like", value, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqIn(List<String> values) {
            addCriterion("rentSelValReq in", values, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotIn(List<String> values) {
            addCriterion("rentSelValReq not in", values, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqBetween(String value1, String value2) {
            addCriterion("rentSelValReq between", value1, value2, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelValReqNotBetween(String value1, String value2) {
            addCriterion("rentSelValReq not between", value1, value2, "rentSelValReq");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIsNull() {
            addCriterion("rentSelRules is null");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIsNotNull() {
            addCriterion("rentSelRules is not null");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesEqualTo(String value) {
            addCriterion("rentSelRules =", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotEqualTo(String value) {
            addCriterion("rentSelRules <>", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesGreaterThan(String value) {
            addCriterion("rentSelRules >", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesGreaterThanOrEqualTo(String value) {
            addCriterion("rentSelRules >=", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLessThan(String value) {
            addCriterion("rentSelRules <", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLessThanOrEqualTo(String value) {
            addCriterion("rentSelRules <=", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesLike(String value) {
            addCriterion("rentSelRules like", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotLike(String value) {
            addCriterion("rentSelRules not like", value, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesIn(List<String> values) {
            addCriterion("rentSelRules in", values, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotIn(List<String> values) {
            addCriterion("rentSelRules not in", values, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesBetween(String value1, String value2) {
            addCriterion("rentSelRules between", value1, value2, "rentSelRules");
            return (Criteria) this;
        }

        public Criteria andRentSelRulesNotBetween(String value1, String value2) {
            addCriterion("rentSelRules not between", value1, value2, "rentSelRules");
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