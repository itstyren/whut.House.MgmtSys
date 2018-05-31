package com.computerdesign.whutHouseMgmt.bean.login;

import java.util.ArrayList;
import java.util.List;

public class WXLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WXLoginExample() {
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

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andSecretIsNull() {
            addCriterion("secret is null");
            return (Criteria) this;
        }

        public Criteria andSecretIsNotNull() {
            addCriterion("secret is not null");
            return (Criteria) this;
        }

        public Criteria andSecretEqualTo(String value) {
            addCriterion("secret =", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            addCriterion("secret <>", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThan(String value) {
            addCriterion("secret >", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            addCriterion("secret >=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThan(String value) {
            addCriterion("secret <", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            addCriterion("secret <=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLike(String value) {
            addCriterion("secret like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotLike(String value) {
            addCriterion("secret not like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretIn(List<String> values) {
            addCriterion("secret in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            addCriterion("secret not in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            addCriterion("secret between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            addCriterion("secret not between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andGrant_typeIsNull() {
            addCriterion("grant_type is null");
            return (Criteria) this;
        }

        public Criteria andGrant_typeIsNotNull() {
            addCriterion("grant_type is not null");
            return (Criteria) this;
        }

        public Criteria andGrant_typeEqualTo(String value) {
            addCriterion("grant_type =", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeNotEqualTo(String value) {
            addCriterion("grant_type <>", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeGreaterThan(String value) {
            addCriterion("grant_type >", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeGreaterThanOrEqualTo(String value) {
            addCriterion("grant_type >=", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeLessThan(String value) {
            addCriterion("grant_type <", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeLessThanOrEqualTo(String value) {
            addCriterion("grant_type <=", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeLike(String value) {
            addCriterion("grant_type like", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeNotLike(String value) {
            addCriterion("grant_type not like", value, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeIn(List<String> values) {
            addCriterion("grant_type in", values, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeNotIn(List<String> values) {
            addCriterion("grant_type not in", values, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeBetween(String value1, String value2) {
            addCriterion("grant_type between", value1, value2, "grant_type");
            return (Criteria) this;
        }

        public Criteria andGrant_typeNotBetween(String value1, String value2) {
            addCriterion("grant_type not between", value1, value2, "grant_type");
            return (Criteria) this;
        }

        public Criteria andJscodeIsNull() {
            addCriterion("jscode is null");
            return (Criteria) this;
        }

        public Criteria andJscodeIsNotNull() {
            addCriterion("jscode is not null");
            return (Criteria) this;
        }

        public Criteria andJscodeEqualTo(String value) {
            addCriterion("jscode =", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeNotEqualTo(String value) {
            addCriterion("jscode <>", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeGreaterThan(String value) {
            addCriterion("jscode >", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeGreaterThanOrEqualTo(String value) {
            addCriterion("jscode >=", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeLessThan(String value) {
            addCriterion("jscode <", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeLessThanOrEqualTo(String value) {
            addCriterion("jscode <=", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeLike(String value) {
            addCriterion("jscode like", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeNotLike(String value) {
            addCriterion("jscode not like", value, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeIn(List<String> values) {
            addCriterion("jscode in", values, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeNotIn(List<String> values) {
            addCriterion("jscode not in", values, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeBetween(String value1, String value2) {
            addCriterion("jscode between", value1, value2, "jscode");
            return (Criteria) this;
        }

        public Criteria andJscodeNotBetween(String value1, String value2) {
            addCriterion("jscode not between", value1, value2, "jscode");
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