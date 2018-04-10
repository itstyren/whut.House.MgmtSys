package com.computerdesign.whutHouseMgmt.bean.staffparam;

import java.util.ArrayList;
import java.util.List;

public class MonetarySubParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonetarySubParamExample() {
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

        public Criteria andIsUsedIsNull() {
            addCriterion("IsUsed is null");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNotNull() {
            addCriterion("IsUsed is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsedEqualTo(Boolean value) {
            addCriterion("IsUsed =", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotEqualTo(Boolean value) {
            addCriterion("IsUsed <>", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThan(Boolean value) {
            addCriterion("IsUsed >", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsUsed >=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThan(Boolean value) {
            addCriterion("IsUsed <", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThanOrEqualTo(Boolean value) {
            addCriterion("IsUsed <=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedIn(List<Boolean> values) {
            addCriterion("IsUsed in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotIn(List<Boolean> values) {
            addCriterion("IsUsed not in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedBetween(Boolean value1, Boolean value2) {
            addCriterion("IsUsed between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsUsed not between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andSubParamIsNull() {
            addCriterion("SubParam is null");
            return (Criteria) this;
        }

        public Criteria andSubParamIsNotNull() {
            addCriterion("SubParam is not null");
            return (Criteria) this;
        }

        public Criteria andSubParamEqualTo(Integer value) {
            addCriterion("SubParam =", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamNotEqualTo(Integer value) {
            addCriterion("SubParam <>", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamGreaterThan(Integer value) {
            addCriterion("SubParam >", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamGreaterThanOrEqualTo(Integer value) {
            addCriterion("SubParam >=", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamLessThan(Integer value) {
            addCriterion("SubParam <", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamLessThanOrEqualTo(Integer value) {
            addCriterion("SubParam <=", value, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamIn(List<Integer> values) {
            addCriterion("SubParam in", values, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamNotIn(List<Integer> values) {
            addCriterion("SubParam not in", values, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamBetween(Integer value1, Integer value2) {
            addCriterion("SubParam between", value1, value2, "subParam");
            return (Criteria) this;
        }

        public Criteria andSubParamNotBetween(Integer value1, Integer value2) {
            addCriterion("SubParam not between", value1, value2, "subParam");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
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