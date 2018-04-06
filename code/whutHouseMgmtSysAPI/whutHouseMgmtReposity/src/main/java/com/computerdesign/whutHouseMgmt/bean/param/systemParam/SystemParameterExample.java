package com.computerdesign.whutHouseMgmt.bean.param.systemParam;

import java.util.ArrayList;
import java.util.List;

public class SystemParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemParameterExample() {
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

        public Criteria andSysParamIdIsNull() {
            addCriterion("SysParamId is null");
            return (Criteria) this;
        }

        public Criteria andSysParamIdIsNotNull() {
            addCriterion("SysParamId is not null");
            return (Criteria) this;
        }

        public Criteria andSysParamIdEqualTo(Integer value) {
            addCriterion("SysParamId =", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdNotEqualTo(Integer value) {
            addCriterion("SysParamId <>", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdGreaterThan(Integer value) {
            addCriterion("SysParamId >", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SysParamId >=", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdLessThan(Integer value) {
            addCriterion("SysParamId <", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("SysParamId <=", value, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdIn(List<Integer> values) {
            addCriterion("SysParamId in", values, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdNotIn(List<Integer> values) {
            addCriterion("SysParamId not in", values, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdBetween(Integer value1, Integer value2) {
            addCriterion("SysParamId between", value1, value2, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SysParamId not between", value1, value2, "sysParamId");
            return (Criteria) this;
        }

        public Criteria andSysParamNameIsNull() {
            addCriterion("SysParamName is null");
            return (Criteria) this;
        }

        public Criteria andSysParamNameIsNotNull() {
            addCriterion("SysParamName is not null");
            return (Criteria) this;
        }

        public Criteria andSysParamNameEqualTo(String value) {
            addCriterion("SysParamName =", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameNotEqualTo(String value) {
            addCriterion("SysParamName <>", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameGreaterThan(String value) {
            addCriterion("SysParamName >", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("SysParamName >=", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameLessThan(String value) {
            addCriterion("SysParamName <", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameLessThanOrEqualTo(String value) {
            addCriterion("SysParamName <=", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameLike(String value) {
            addCriterion("SysParamName like", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameNotLike(String value) {
            addCriterion("SysParamName not like", value, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameIn(List<String> values) {
            addCriterion("SysParamName in", values, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameNotIn(List<String> values) {
            addCriterion("SysParamName not in", values, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameBetween(String value1, String value2) {
            addCriterion("SysParamName between", value1, value2, "sysParamName");
            return (Criteria) this;
        }

        public Criteria andSysParamNameNotBetween(String value1, String value2) {
            addCriterion("SysParamName not between", value1, value2, "sysParamName");
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