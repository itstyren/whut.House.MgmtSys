package com.computerdesign.whutHouseMgmt.bean.building;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("BuildingId is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("BuildingId is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("BuildingId =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("BuildingId <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("BuildingId >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BuildingId >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("BuildingId <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("BuildingId <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("BuildingId in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("BuildingId not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("BuildingId between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BuildingId not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("BuildingName is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("BuildingName is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("BuildingName =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("BuildingName <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("BuildingName >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("BuildingName >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("BuildingName <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("BuildingName <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("BuildingName like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("BuildingName not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("BuildingName in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("BuildingName not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("BuildingName between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("BuildingName not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeIsNull() {
            addCriterion("BuildingFinishTime is null");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeIsNotNull() {
            addCriterion("BuildingFinishTime is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeEqualTo(Date value) {
            addCriterion("BuildingFinishTime =", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeNotEqualTo(Date value) {
            addCriterion("BuildingFinishTime <>", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeGreaterThan(Date value) {
            addCriterion("BuildingFinishTime >", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BuildingFinishTime >=", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeLessThan(Date value) {
            addCriterion("BuildingFinishTime <", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("BuildingFinishTime <=", value, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeIn(List<Date> values) {
            addCriterion("BuildingFinishTime in", values, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeNotIn(List<Date> values) {
            addCriterion("BuildingFinishTime not in", values, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeBetween(Date value1, Date value2) {
            addCriterion("BuildingFinishTime between", value1, value2, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("BuildingFinishTime not between", value1, value2, "buildingFinishTime");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaIsNull() {
            addCriterion("BuildingFloorArea is null");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaIsNotNull() {
            addCriterion("BuildingFloorArea is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaEqualTo(Float value) {
            addCriterion("BuildingFloorArea =", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaNotEqualTo(Float value) {
            addCriterion("BuildingFloorArea <>", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaGreaterThan(Float value) {
            addCriterion("BuildingFloorArea >", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("BuildingFloorArea >=", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaLessThan(Float value) {
            addCriterion("BuildingFloorArea <", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaLessThanOrEqualTo(Float value) {
            addCriterion("BuildingFloorArea <=", value, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaIn(List<Float> values) {
            addCriterion("BuildingFloorArea in", values, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaNotIn(List<Float> values) {
            addCriterion("BuildingFloorArea not in", values, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaBetween(Float value1, Float value2) {
            addCriterion("BuildingFloorArea between", value1, value2, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorAreaNotBetween(Float value1, Float value2) {
            addCriterion("BuildingFloorArea not between", value1, value2, "buildingFloorArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaIsNull() {
            addCriterion("BuildingUsedArea is null");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaIsNotNull() {
            addCriterion("BuildingUsedArea is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaEqualTo(Float value) {
            addCriterion("BuildingUsedArea =", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaNotEqualTo(Float value) {
            addCriterion("BuildingUsedArea <>", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaGreaterThan(Float value) {
            addCriterion("BuildingUsedArea >", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("BuildingUsedArea >=", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaLessThan(Float value) {
            addCriterion("BuildingUsedArea <", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaLessThanOrEqualTo(Float value) {
            addCriterion("BuildingUsedArea <=", value, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaIn(List<Float> values) {
            addCriterion("BuildingUsedArea in", values, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaNotIn(List<Float> values) {
            addCriterion("BuildingUsedArea not in", values, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaBetween(Float value1, Float value2) {
            addCriterion("BuildingUsedArea between", value1, value2, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingUsedAreaNotBetween(Float value1, Float value2) {
            addCriterion("BuildingUsedArea not between", value1, value2, "buildingUsedArea");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountIsNull() {
            addCriterion("BuildingFloorCount is null");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountIsNotNull() {
            addCriterion("BuildingFloorCount is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountEqualTo(Integer value) {
            addCriterion("BuildingFloorCount =", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountNotEqualTo(Integer value) {
            addCriterion("BuildingFloorCount <>", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountGreaterThan(Integer value) {
            addCriterion("BuildingFloorCount >", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BuildingFloorCount >=", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountLessThan(Integer value) {
            addCriterion("BuildingFloorCount <", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountLessThanOrEqualTo(Integer value) {
            addCriterion("BuildingFloorCount <=", value, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountIn(List<Integer> values) {
            addCriterion("BuildingFloorCount in", values, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountNotIn(List<Integer> values) {
            addCriterion("BuildingFloorCount not in", values, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountBetween(Integer value1, Integer value2) {
            addCriterion("BuildingFloorCount between", value1, value2, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingFloorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BuildingFloorCount not between", value1, value2, "buildingFloorCount");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionIsNull() {
            addCriterion("BuildingRegion is null");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionIsNotNull() {
            addCriterion("BuildingRegion is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionEqualTo(Integer value) {
            addCriterion("BuildingRegion =", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionNotEqualTo(Integer value) {
            addCriterion("BuildingRegion <>", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionGreaterThan(Integer value) {
            addCriterion("BuildingRegion >", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionGreaterThanOrEqualTo(Integer value) {
            addCriterion("BuildingRegion >=", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionLessThan(Integer value) {
            addCriterion("BuildingRegion <", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionLessThanOrEqualTo(Integer value) {
            addCriterion("BuildingRegion <=", value, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionIn(List<Integer> values) {
            addCriterion("BuildingRegion in", values, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionNotIn(List<Integer> values) {
            addCriterion("BuildingRegion not in", values, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionBetween(Integer value1, Integer value2) {
            addCriterion("BuildingRegion between", value1, value2, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingRegionNotBetween(Integer value1, Integer value2) {
            addCriterion("BuildingRegion not between", value1, value2, "buildingRegion");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionIsNull() {
            addCriterion("BuildingDescription is null");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionIsNotNull() {
            addCriterion("BuildingDescription is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionEqualTo(String value) {
            addCriterion("BuildingDescription =", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionNotEqualTo(String value) {
            addCriterion("BuildingDescription <>", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionGreaterThan(String value) {
            addCriterion("BuildingDescription >", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("BuildingDescription >=", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionLessThan(String value) {
            addCriterion("BuildingDescription <", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionLessThanOrEqualTo(String value) {
            addCriterion("BuildingDescription <=", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionLike(String value) {
            addCriterion("BuildingDescription like", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionNotLike(String value) {
            addCriterion("BuildingDescription not like", value, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionIn(List<String> values) {
            addCriterion("BuildingDescription in", values, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionNotIn(List<String> values) {
            addCriterion("BuildingDescription not in", values, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionBetween(String value1, String value2) {
            addCriterion("BuildingDescription between", value1, value2, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingDescriptionNotBetween(String value1, String value2) {
            addCriterion("BuildingDescription not between", value1, value2, "buildingDescription");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundIsNull() {
            addCriterion("BuildingSupportFund is null");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundIsNotNull() {
            addCriterion("BuildingSupportFund is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundEqualTo(Long value) {
            addCriterion("BuildingSupportFund =", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundNotEqualTo(Long value) {
            addCriterion("BuildingSupportFund <>", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundGreaterThan(Long value) {
            addCriterion("BuildingSupportFund >", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundGreaterThanOrEqualTo(Long value) {
            addCriterion("BuildingSupportFund >=", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundLessThan(Long value) {
            addCriterion("BuildingSupportFund <", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundLessThanOrEqualTo(Long value) {
            addCriterion("BuildingSupportFund <=", value, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundIn(List<Long> values) {
            addCriterion("BuildingSupportFund in", values, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundNotIn(List<Long> values) {
            addCriterion("BuildingSupportFund not in", values, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundBetween(Long value1, Long value2) {
            addCriterion("BuildingSupportFund between", value1, value2, "buildingSupportFund");
            return (Criteria) this;
        }

        public Criteria andBuildingSupportFundNotBetween(Long value1, Long value2) {
            addCriterion("BuildingSupportFund not between", value1, value2, "buildingSupportFund");
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