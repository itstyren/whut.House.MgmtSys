package com.computerdesign.whutHouseMgmt.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeParameterExample() {
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

        public Criteria andEmployeeParamIdIsNull() {
            addCriterion("EmployeeParamId is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdIsNotNull() {
            addCriterion("EmployeeParamId is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdEqualTo(Integer value) {
            addCriterion("EmployeeParamId =", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdNotEqualTo(Integer value) {
            addCriterion("EmployeeParamId <>", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdGreaterThan(Integer value) {
            addCriterion("EmployeeParamId >", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamId >=", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdLessThan(Integer value) {
            addCriterion("EmployeeParamId <", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamId <=", value, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdIn(List<Integer> values) {
            addCriterion("EmployeeParamId in", values, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdNotIn(List<Integer> values) {
            addCriterion("EmployeeParamId not in", values, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamId between", value1, value2, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamId not between", value1, value2, "employeeParamId");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameIsNull() {
            addCriterion("EmployeeParamName is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameIsNotNull() {
            addCriterion("EmployeeParamName is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameEqualTo(String value) {
            addCriterion("EmployeeParamName =", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameNotEqualTo(String value) {
            addCriterion("EmployeeParamName <>", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameGreaterThan(String value) {
            addCriterion("EmployeeParamName >", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("EmployeeParamName >=", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameLessThan(String value) {
            addCriterion("EmployeeParamName <", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameLessThanOrEqualTo(String value) {
            addCriterion("EmployeeParamName <=", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameLike(String value) {
            addCriterion("EmployeeParamName like", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameNotLike(String value) {
            addCriterion("EmployeeParamName not like", value, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameIn(List<String> values) {
            addCriterion("EmployeeParamName in", values, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameNotIn(List<String> values) {
            addCriterion("EmployeeParamName not in", values, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameBetween(String value1, String value2) {
            addCriterion("EmployeeParamName between", value1, value2, "employeeParamName");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamNameNotBetween(String value1, String value2) {
            addCriterion("EmployeeParamName not between", value1, value2, "employeeParamName");
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

        public Criteria andEmployeeParamFraIsNull() {
            addCriterion("EmployeeParamFra is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraIsNotNull() {
            addCriterion("EmployeeParamFra is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraEqualTo(Integer value) {
            addCriterion("EmployeeParamFra =", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraNotEqualTo(Integer value) {
            addCriterion("EmployeeParamFra <>", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraGreaterThan(Integer value) {
            addCriterion("EmployeeParamFra >", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraGreaterThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamFra >=", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraLessThan(Integer value) {
            addCriterion("EmployeeParamFra <", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraLessThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamFra <=", value, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraIn(List<Integer> values) {
            addCriterion("EmployeeParamFra in", values, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraNotIn(List<Integer> values) {
            addCriterion("EmployeeParamFra not in", values, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamFra between", value1, value2, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamFraNotBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamFra not between", value1, value2, "employeeParamFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraIsNull() {
            addCriterion("EmployeeParamSpouseFra is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraIsNotNull() {
            addCriterion("EmployeeParamSpouseFra is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraEqualTo(Integer value) {
            addCriterion("EmployeeParamSpouseFra =", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraNotEqualTo(Integer value) {
            addCriterion("EmployeeParamSpouseFra <>", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraGreaterThan(Integer value) {
            addCriterion("EmployeeParamSpouseFra >", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraGreaterThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamSpouseFra >=", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraLessThan(Integer value) {
            addCriterion("EmployeeParamSpouseFra <", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraLessThanOrEqualTo(Integer value) {
            addCriterion("EmployeeParamSpouseFra <=", value, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraIn(List<Integer> values) {
            addCriterion("EmployeeParamSpouseFra in", values, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraNotIn(List<Integer> values) {
            addCriterion("EmployeeParamSpouseFra not in", values, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamSpouseFra between", value1, value2, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamSpouseFraNotBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeParamSpouseFra not between", value1, value2, "employeeParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaIsNull() {
            addCriterion("EmployeeParamHouseArea is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaIsNotNull() {
            addCriterion("EmployeeParamHouseArea is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaEqualTo(Float value) {
            addCriterion("EmployeeParamHouseArea =", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaNotEqualTo(Float value) {
            addCriterion("EmployeeParamHouseArea <>", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaGreaterThan(Float value) {
            addCriterion("EmployeeParamHouseArea >", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("EmployeeParamHouseArea >=", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaLessThan(Float value) {
            addCriterion("EmployeeParamHouseArea <", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaLessThanOrEqualTo(Float value) {
            addCriterion("EmployeeParamHouseArea <=", value, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaIn(List<Float> values) {
            addCriterion("EmployeeParamHouseArea in", values, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaNotIn(List<Float> values) {
            addCriterion("EmployeeParamHouseArea not in", values, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaBetween(Float value1, Float value2) {
            addCriterion("EmployeeParamHouseArea between", value1, value2, "employeeParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andEmployeeParamHouseAreaNotBetween(Float value1, Float value2) {
            addCriterion("EmployeeParamHouseArea not between", value1, value2, "employeeParamHouseArea");
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