package com.computerdesign.whutHouseMgmt.bean.authority;

import java.util.ArrayList;
import java.util.List;

public class QiniuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QiniuExample() {
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

        public Criteria andAccessKeyIsNull() {
            addCriterion("AccessKey is null");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIsNotNull() {
            addCriterion("AccessKey is not null");
            return (Criteria) this;
        }

        public Criteria andAccessKeyEqualTo(String value) {
            addCriterion("AccessKey =", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyNotEqualTo(String value) {
            addCriterion("AccessKey <>", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyGreaterThan(String value) {
            addCriterion("AccessKey >", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("AccessKey >=", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyLessThan(String value) {
            addCriterion("AccessKey <", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyLessThanOrEqualTo(String value) {
            addCriterion("AccessKey <=", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyLike(String value) {
            addCriterion("AccessKey like", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyNotLike(String value) {
            addCriterion("AccessKey not like", value, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIn(List<String> values) {
            addCriterion("AccessKey in", values, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyNotIn(List<String> values) {
            addCriterion("AccessKey not in", values, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyBetween(String value1, String value2) {
            addCriterion("AccessKey between", value1, value2, "accessKey");
            return (Criteria) this;
        }

        public Criteria andAccessKeyNotBetween(String value1, String value2) {
            addCriterion("AccessKey not between", value1, value2, "accessKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIsNull() {
            addCriterion("SecretKey is null");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIsNotNull() {
            addCriterion("SecretKey is not null");
            return (Criteria) this;
        }

        public Criteria andSecretKeyEqualTo(String value) {
            addCriterion("SecretKey =", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotEqualTo(String value) {
            addCriterion("SecretKey <>", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyGreaterThan(String value) {
            addCriterion("SecretKey >", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SecretKey >=", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLessThan(String value) {
            addCriterion("SecretKey <", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLessThanOrEqualTo(String value) {
            addCriterion("SecretKey <=", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLike(String value) {
            addCriterion("SecretKey like", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotLike(String value) {
            addCriterion("SecretKey not like", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIn(List<String> values) {
            addCriterion("SecretKey in", values, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotIn(List<String> values) {
            addCriterion("SecretKey not in", values, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyBetween(String value1, String value2) {
            addCriterion("SecretKey between", value1, value2, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotBetween(String value1, String value2) {
            addCriterion("SecretKey not between", value1, value2, "secretKey");
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