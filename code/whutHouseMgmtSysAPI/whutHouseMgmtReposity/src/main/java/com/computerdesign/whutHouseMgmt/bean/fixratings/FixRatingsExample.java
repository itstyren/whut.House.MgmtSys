package com.computerdesign.whutHouseMgmt.bean.fixratings;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FixRatingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FixRatingsExample() {
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

        public Criteria andFixIdIsNull() {
            addCriterion("FixId is null");
            return (Criteria) this;
        }

        public Criteria andFixIdIsNotNull() {
            addCriterion("FixId is not null");
            return (Criteria) this;
        }

        public Criteria andFixIdEqualTo(Integer value) {
            addCriterion("FixId =", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdNotEqualTo(Integer value) {
            addCriterion("FixId <>", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdGreaterThan(Integer value) {
            addCriterion("FixId >", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FixId >=", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdLessThan(Integer value) {
            addCriterion("FixId <", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdLessThanOrEqualTo(Integer value) {
            addCriterion("FixId <=", value, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdIn(List<Integer> values) {
            addCriterion("FixId in", values, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdNotIn(List<Integer> values) {
            addCriterion("FixId not in", values, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdBetween(Integer value1, Integer value2) {
            addCriterion("FixId between", value1, value2, "fixId");
            return (Criteria) this;
        }

        public Criteria andFixIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FixId not between", value1, value2, "fixId");
            return (Criteria) this;
        }

        public Criteria andRatingsIsNull() {
            addCriterion("Ratings is null");
            return (Criteria) this;
        }

        public Criteria andRatingsIsNotNull() {
            addCriterion("Ratings is not null");
            return (Criteria) this;
        }

        public Criteria andRatingsEqualTo(String value) {
            addCriterion("Ratings =", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsNotEqualTo(String value) {
            addCriterion("Ratings <>", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsGreaterThan(String value) {
            addCriterion("Ratings >", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsGreaterThanOrEqualTo(String value) {
            addCriterion("Ratings >=", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsLessThan(String value) {
            addCriterion("Ratings <", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsLessThanOrEqualTo(String value) {
            addCriterion("Ratings <=", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsLike(String value) {
            addCriterion("Ratings like", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsNotLike(String value) {
            addCriterion("Ratings not like", value, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsIn(List<String> values) {
            addCriterion("Ratings in", values, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsNotIn(List<String> values) {
            addCriterion("Ratings not in", values, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsBetween(String value1, String value2) {
            addCriterion("Ratings between", value1, value2, "ratings");
            return (Criteria) this;
        }

        public Criteria andRatingsNotBetween(String value1, String value2) {
            addCriterion("Ratings not between", value1, value2, "ratings");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("SubmitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("SubmitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("SubmitTime =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("SubmitTime <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("SubmitTime >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SubmitTime >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("SubmitTime <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("SubmitTime <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("SubmitTime in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("SubmitTime not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("SubmitTime between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("SubmitTime not between", value1, value2, "submitTime");
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