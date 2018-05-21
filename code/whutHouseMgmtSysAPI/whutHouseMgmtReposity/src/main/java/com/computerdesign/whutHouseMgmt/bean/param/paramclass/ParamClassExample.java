package com.computerdesign.whutHouseMgmt.bean.param.paramclass;

import java.util.ArrayList;
import java.util.List;

public class ParamClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParamClassExample() {
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

        public Criteria andParamTypeINameIsNull() {
            addCriterion("ParamTypeIName is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameIsNotNull() {
            addCriterion("ParamTypeIName is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameEqualTo(String value) {
            addCriterion("ParamTypeIName =", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameNotEqualTo(String value) {
            addCriterion("ParamTypeIName <>", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameGreaterThan(String value) {
            addCriterion("ParamTypeIName >", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameGreaterThanOrEqualTo(String value) {
            addCriterion("ParamTypeIName >=", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameLessThan(String value) {
            addCriterion("ParamTypeIName <", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameLessThanOrEqualTo(String value) {
            addCriterion("ParamTypeIName <=", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameLike(String value) {
            addCriterion("ParamTypeIName like", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameNotLike(String value) {
            addCriterion("ParamTypeIName not like", value, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameIn(List<String> values) {
            addCriterion("ParamTypeIName in", values, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameNotIn(List<String> values) {
            addCriterion("ParamTypeIName not in", values, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameBetween(String value1, String value2) {
            addCriterion("ParamTypeIName between", value1, value2, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamTypeINameNotBetween(String value1, String value2) {
            addCriterion("ParamTypeIName not between", value1, value2, "paramTypeIName");
            return (Criteria) this;
        }

        public Criteria andParamClassIdIsNull() {
            addCriterion("ParamClassId is null");
            return (Criteria) this;
        }

        public Criteria andParamClassIdIsNotNull() {
            addCriterion("ParamClassId is not null");
            return (Criteria) this;
        }

        public Criteria andParamClassIdEqualTo(String value) {
            addCriterion("ParamClassId =", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdNotEqualTo(String value) {
            addCriterion("ParamClassId <>", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdGreaterThan(String value) {
            addCriterion("ParamClassId >", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("ParamClassId >=", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdLessThan(String value) {
            addCriterion("ParamClassId <", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdLessThanOrEqualTo(String value) {
            addCriterion("ParamClassId <=", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdLike(String value) {
            addCriterion("ParamClassId like", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdNotLike(String value) {
            addCriterion("ParamClassId not like", value, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdIn(List<String> values) {
            addCriterion("ParamClassId in", values, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdNotIn(List<String> values) {
            addCriterion("ParamClassId not in", values, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdBetween(String value1, String value2) {
            addCriterion("ParamClassId between", value1, value2, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassIdNotBetween(String value1, String value2) {
            addCriterion("ParamClassId not between", value1, value2, "paramClassId");
            return (Criteria) this;
        }

        public Criteria andParamClassNameIsNull() {
            addCriterion("ParamClassName is null");
            return (Criteria) this;
        }

        public Criteria andParamClassNameIsNotNull() {
            addCriterion("ParamClassName is not null");
            return (Criteria) this;
        }

        public Criteria andParamClassNameEqualTo(String value) {
            addCriterion("ParamClassName =", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameNotEqualTo(String value) {
            addCriterion("ParamClassName <>", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameGreaterThan(String value) {
            addCriterion("ParamClassName >", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("ParamClassName >=", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameLessThan(String value) {
            addCriterion("ParamClassName <", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameLessThanOrEqualTo(String value) {
            addCriterion("ParamClassName <=", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameLike(String value) {
            addCriterion("ParamClassName like", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameNotLike(String value) {
            addCriterion("ParamClassName not like", value, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameIn(List<String> values) {
            addCriterion("ParamClassName in", values, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameNotIn(List<String> values) {
            addCriterion("ParamClassName not in", values, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameBetween(String value1, String value2) {
            addCriterion("ParamClassName between", value1, value2, "paramClassName");
            return (Criteria) this;
        }

        public Criteria andParamClassNameNotBetween(String value1, String value2) {
            addCriterion("ParamClassName not between", value1, value2, "paramClassName");
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