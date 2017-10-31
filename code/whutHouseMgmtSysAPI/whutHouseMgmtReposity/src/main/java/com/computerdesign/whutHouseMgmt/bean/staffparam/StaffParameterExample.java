package com.computerdesign.whutHouseMgmt.bean.staffparam;

import java.util.ArrayList;
import java.util.List;

public class StaffParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffParameterExample() {
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

        public Criteria andStaffParamIdIsNull() {
            addCriterion("StaffParamId is null");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdIsNotNull() {
            addCriterion("StaffParamId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdEqualTo(Integer value) {
            addCriterion("StaffParamId =", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdNotEqualTo(Integer value) {
            addCriterion("StaffParamId <>", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdGreaterThan(Integer value) {
            addCriterion("StaffParamId >", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffParamId >=", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdLessThan(Integer value) {
            addCriterion("StaffParamId <", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffParamId <=", value, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdIn(List<Integer> values) {
            addCriterion("StaffParamId in", values, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdNotIn(List<Integer> values) {
            addCriterion("StaffParamId not in", values, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamId between", value1, value2, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamId not between", value1, value2, "staffParamId");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameIsNull() {
            addCriterion("StaffParamName is null");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameIsNotNull() {
            addCriterion("StaffParamName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameEqualTo(String value) {
            addCriterion("StaffParamName =", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameNotEqualTo(String value) {
            addCriterion("StaffParamName <>", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameGreaterThan(String value) {
            addCriterion("StaffParamName >", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffParamName >=", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameLessThan(String value) {
            addCriterion("StaffParamName <", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameLessThanOrEqualTo(String value) {
            addCriterion("StaffParamName <=", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameLike(String value) {
            addCriterion("StaffParamName like", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameNotLike(String value) {
            addCriterion("StaffParamName not like", value, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameIn(List<String> values) {
            addCriterion("StaffParamName in", values, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameNotIn(List<String> values) {
            addCriterion("StaffParamName not in", values, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameBetween(String value1, String value2) {
            addCriterion("StaffParamName between", value1, value2, "staffParamName");
            return (Criteria) this;
        }

        public Criteria andStaffParamNameNotBetween(String value1, String value2) {
            addCriterion("StaffParamName not between", value1, value2, "staffParamName");
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

        public Criteria andStaffParamFraIsNull() {
            addCriterion("StaffParamFra is null");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraIsNotNull() {
            addCriterion("StaffParamFra is not null");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraEqualTo(Integer value) {
            addCriterion("StaffParamFra =", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraNotEqualTo(Integer value) {
            addCriterion("StaffParamFra <>", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraGreaterThan(Integer value) {
            addCriterion("StaffParamFra >", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffParamFra >=", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraLessThan(Integer value) {
            addCriterion("StaffParamFra <", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraLessThanOrEqualTo(Integer value) {
            addCriterion("StaffParamFra <=", value, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraIn(List<Integer> values) {
            addCriterion("StaffParamFra in", values, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraNotIn(List<Integer> values) {
            addCriterion("StaffParamFra not in", values, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamFra between", value1, value2, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamFraNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamFra not between", value1, value2, "staffParamFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraIsNull() {
            addCriterion("StaffParamSpouseFra is null");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraIsNotNull() {
            addCriterion("StaffParamSpouseFra is not null");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraEqualTo(Integer value) {
            addCriterion("StaffParamSpouseFra =", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraNotEqualTo(Integer value) {
            addCriterion("StaffParamSpouseFra <>", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraGreaterThan(Integer value) {
            addCriterion("StaffParamSpouseFra >", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffParamSpouseFra >=", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraLessThan(Integer value) {
            addCriterion("StaffParamSpouseFra <", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraLessThanOrEqualTo(Integer value) {
            addCriterion("StaffParamSpouseFra <=", value, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraIn(List<Integer> values) {
            addCriterion("StaffParamSpouseFra in", values, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraNotIn(List<Integer> values) {
            addCriterion("StaffParamSpouseFra not in", values, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamSpouseFra between", value1, value2, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamSpouseFraNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffParamSpouseFra not between", value1, value2, "staffParamSpouseFra");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaIsNull() {
            addCriterion("StaffParamHouseArea is null");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaIsNotNull() {
            addCriterion("StaffParamHouseArea is not null");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaEqualTo(Float value) {
            addCriterion("StaffParamHouseArea =", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaNotEqualTo(Float value) {
            addCriterion("StaffParamHouseArea <>", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaGreaterThan(Float value) {
            addCriterion("StaffParamHouseArea >", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("StaffParamHouseArea >=", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaLessThan(Float value) {
            addCriterion("StaffParamHouseArea <", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaLessThanOrEqualTo(Float value) {
            addCriterion("StaffParamHouseArea <=", value, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaIn(List<Float> values) {
            addCriterion("StaffParamHouseArea in", values, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaNotIn(List<Float> values) {
            addCriterion("StaffParamHouseArea not in", values, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaBetween(Float value1, Float value2) {
            addCriterion("StaffParamHouseArea between", value1, value2, "staffParamHouseArea");
            return (Criteria) this;
        }

        public Criteria andStaffParamHouseAreaNotBetween(Float value1, Float value2) {
            addCriterion("StaffParamHouseArea not between", value1, value2, "staffParamHouseArea");
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