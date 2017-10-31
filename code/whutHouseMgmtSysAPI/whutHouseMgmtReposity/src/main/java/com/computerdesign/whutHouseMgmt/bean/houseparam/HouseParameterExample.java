package com.computerdesign.whutHouseMgmt.bean.houseparam;

import java.util.ArrayList;
import java.util.List;

public class HouseParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseParameterExample() {
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

        public Criteria andHouseParamIdIsNull() {
            addCriterion("HouseParamId is null");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdIsNotNull() {
            addCriterion("HouseParamId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdEqualTo(Integer value) {
            addCriterion("HouseParamId =", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdNotEqualTo(Integer value) {
            addCriterion("HouseParamId <>", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdGreaterThan(Integer value) {
            addCriterion("HouseParamId >", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseParamId >=", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdLessThan(Integer value) {
            addCriterion("HouseParamId <", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseParamId <=", value, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdIn(List<Integer> values) {
            addCriterion("HouseParamId in", values, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdNotIn(List<Integer> values) {
            addCriterion("HouseParamId not in", values, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseParamId between", value1, value2, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseParamId not between", value1, value2, "houseParamId");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameIsNull() {
            addCriterion("HouseParamName is null");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameIsNotNull() {
            addCriterion("HouseParamName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameEqualTo(String value) {
            addCriterion("HouseParamName =", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameNotEqualTo(String value) {
            addCriterion("HouseParamName <>", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameGreaterThan(String value) {
            addCriterion("HouseParamName >", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseParamName >=", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameLessThan(String value) {
            addCriterion("HouseParamName <", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameLessThanOrEqualTo(String value) {
            addCriterion("HouseParamName <=", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameLike(String value) {
            addCriterion("HouseParamName like", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameNotLike(String value) {
            addCriterion("HouseParamName not like", value, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameIn(List<String> values) {
            addCriterion("HouseParamName in", values, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameNotIn(List<String> values) {
            addCriterion("HouseParamName not in", values, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameBetween(String value1, String value2) {
            addCriterion("HouseParamName between", value1, value2, "houseParamName");
            return (Criteria) this;
        }

        public Criteria andHouseParamNameNotBetween(String value1, String value2) {
            addCriterion("HouseParamName not between", value1, value2, "houseParamName");
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

        public Criteria andHouseParamRelIsNull() {
            addCriterion("HouseParamRel is null");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelIsNotNull() {
            addCriterion("HouseParamRel is not null");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelEqualTo(String value) {
            addCriterion("HouseParamRel =", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelNotEqualTo(String value) {
            addCriterion("HouseParamRel <>", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelGreaterThan(String value) {
            addCriterion("HouseParamRel >", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelGreaterThanOrEqualTo(String value) {
            addCriterion("HouseParamRel >=", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelLessThan(String value) {
            addCriterion("HouseParamRel <", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelLessThanOrEqualTo(String value) {
            addCriterion("HouseParamRel <=", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelLike(String value) {
            addCriterion("HouseParamRel like", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelNotLike(String value) {
            addCriterion("HouseParamRel not like", value, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelIn(List<String> values) {
            addCriterion("HouseParamRel in", values, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelNotIn(List<String> values) {
            addCriterion("HouseParamRel not in", values, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelBetween(String value1, String value2) {
            addCriterion("HouseParamRel between", value1, value2, "houseParamRel");
            return (Criteria) this;
        }

        public Criteria andHouseParamRelNotBetween(String value1, String value2) {
            addCriterion("HouseParamRel not between", value1, value2, "houseParamRel");
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