package com.computerdesign.whutHouseMgmt.bean.houseManagement.house;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andNoIsNull() {
            addCriterion("No is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("No is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("No =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("No <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("No >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("No >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("No <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("No <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("No like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("No not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("No in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("No not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("No between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("No not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolIsNull() {
            addCriterion("IsOutSchool is null");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolIsNotNull() {
            addCriterion("IsOutSchool is not null");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolEqualTo(Boolean value) {
            addCriterion("IsOutSchool =", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolNotEqualTo(Boolean value) {
            addCriterion("IsOutSchool <>", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolGreaterThan(Boolean value) {
            addCriterion("IsOutSchool >", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsOutSchool >=", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolLessThan(Boolean value) {
            addCriterion("IsOutSchool <", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolLessThanOrEqualTo(Boolean value) {
            addCriterion("IsOutSchool <=", value, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolIn(List<Boolean> values) {
            addCriterion("IsOutSchool in", values, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolNotIn(List<Boolean> values) {
            addCriterion("IsOutSchool not in", values, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOutSchool between", value1, value2, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andIsOutSchoolNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOutSchool not between", value1, value2, "isOutSchool");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNull() {
            addCriterion("Layout is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNotNull() {
            addCriterion("Layout is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutEqualTo(Integer value) {
            addCriterion("Layout =", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotEqualTo(Integer value) {
            addCriterion("Layout <>", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThan(Integer value) {
            addCriterion("Layout >", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("Layout >=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThan(Integer value) {
            addCriterion("Layout <", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThanOrEqualTo(Integer value) {
            addCriterion("Layout <=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutIn(List<Integer> values) {
            addCriterion("Layout in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotIn(List<Integer> values) {
            addCriterion("Layout not in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutBetween(Integer value1, Integer value2) {
            addCriterion("Layout between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotBetween(Integer value1, Integer value2) {
            addCriterion("Layout not between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andStructIsNull() {
            addCriterion("Struct is null");
            return (Criteria) this;
        }

        public Criteria andStructIsNotNull() {
            addCriterion("Struct is not null");
            return (Criteria) this;
        }

        public Criteria andStructEqualTo(Integer value) {
            addCriterion("Struct =", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotEqualTo(Integer value) {
            addCriterion("Struct <>", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructGreaterThan(Integer value) {
            addCriterion("Struct >", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructGreaterThanOrEqualTo(Integer value) {
            addCriterion("Struct >=", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructLessThan(Integer value) {
            addCriterion("Struct <", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructLessThanOrEqualTo(Integer value) {
            addCriterion("Struct <=", value, "struct");
            return (Criteria) this;
        }

        public Criteria andStructIn(List<Integer> values) {
            addCriterion("Struct in", values, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotIn(List<Integer> values) {
            addCriterion("Struct not in", values, "struct");
            return (Criteria) this;
        }

        public Criteria andStructBetween(Integer value1, Integer value2) {
            addCriterion("Struct between", value1, value2, "struct");
            return (Criteria) this;
        }

        public Criteria andStructNotBetween(Integer value1, Integer value2) {
            addCriterion("Struct not between", value1, value2, "struct");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("BuildArea is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("BuildArea is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(Double value) {
            addCriterion("BuildArea =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(Double value) {
            addCriterion("BuildArea <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(Double value) {
            addCriterion("BuildArea >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("BuildArea >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(Double value) {
            addCriterion("BuildArea <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(Double value) {
            addCriterion("BuildArea <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<Double> values) {
            addCriterion("BuildArea in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<Double> values) {
            addCriterion("BuildArea not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(Double value1, Double value2) {
            addCriterion("BuildArea between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(Double value1, Double value2) {
            addCriterion("BuildArea not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaIsNull() {
            addCriterion("UsedArea is null");
            return (Criteria) this;
        }

        public Criteria andUsedAreaIsNotNull() {
            addCriterion("UsedArea is not null");
            return (Criteria) this;
        }

        public Criteria andUsedAreaEqualTo(Double value) {
            addCriterion("UsedArea =", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaNotEqualTo(Double value) {
            addCriterion("UsedArea <>", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaGreaterThan(Double value) {
            addCriterion("UsedArea >", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("UsedArea >=", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaLessThan(Double value) {
            addCriterion("UsedArea <", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaLessThanOrEqualTo(Double value) {
            addCriterion("UsedArea <=", value, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaIn(List<Double> values) {
            addCriterion("UsedArea in", values, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaNotIn(List<Double> values) {
            addCriterion("UsedArea not in", values, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaBetween(Double value1, Double value2) {
            addCriterion("UsedArea between", value1, value2, "usedArea");
            return (Criteria) this;
        }

        public Criteria andUsedAreaNotBetween(Double value1, Double value2) {
            addCriterion("UsedArea not between", value1, value2, "usedArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaIsNull() {
            addCriterion("BasementArea is null");
            return (Criteria) this;
        }

        public Criteria andBasementAreaIsNotNull() {
            addCriterion("BasementArea is not null");
            return (Criteria) this;
        }

        public Criteria andBasementAreaEqualTo(Double value) {
            addCriterion("BasementArea =", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaNotEqualTo(Double value) {
            addCriterion("BasementArea <>", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaGreaterThan(Double value) {
            addCriterion("BasementArea >", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("BasementArea >=", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaLessThan(Double value) {
            addCriterion("BasementArea <", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaLessThanOrEqualTo(Double value) {
            addCriterion("BasementArea <=", value, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaIn(List<Double> values) {
            addCriterion("BasementArea in", values, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaNotIn(List<Double> values) {
            addCriterion("BasementArea not in", values, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaBetween(Double value1, Double value2) {
            addCriterion("BasementArea between", value1, value2, "basementArea");
            return (Criteria) this;
        }

        public Criteria andBasementAreaNotBetween(Double value1, Double value2) {
            addCriterion("BasementArea not between", value1, value2, "basementArea");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
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

        public Criteria andProIdIsNull() {
            addCriterion("ProId is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("ProId is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("ProId =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("ProId <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("ProId >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("ProId >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("ProId <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("ProId <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("ProId like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("ProId not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("ProId in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("ProId not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("ProId between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("ProId not between", value1, value2, "proId");
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

        public Criteria andImageIsNull() {
            addCriterion("Image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("Image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("Image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("Image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("Image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("Image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("Image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("Image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("Image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("Image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("Image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("Image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("Image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("Image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andRentalIsNull() {
            addCriterion("Rental is null");
            return (Criteria) this;
        }

        public Criteria andRentalIsNotNull() {
            addCriterion("Rental is not null");
            return (Criteria) this;
        }

        public Criteria andRentalEqualTo(Double value) {
            addCriterion("Rental =", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotEqualTo(Double value) {
            addCriterion("Rental <>", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThan(Double value) {
            addCriterion("Rental >", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalGreaterThanOrEqualTo(Double value) {
            addCriterion("Rental >=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThan(Double value) {
            addCriterion("Rental <", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalLessThanOrEqualTo(Double value) {
            addCriterion("Rental <=", value, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalIn(List<Double> values) {
            addCriterion("Rental in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotIn(List<Double> values) {
            addCriterion("Rental not in", values, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalBetween(Double value1, Double value2) {
            addCriterion("Rental between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andRentalNotBetween(Double value1, Double value2) {
            addCriterion("Rental not between", value1, value2, "rental");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("FinishTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("FinishTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FinishTime =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FinishTime <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FinishTime >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FinishTime >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("FinishTime <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FinishTime <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FinishTime in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FinishTime not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FinishTime between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FinishTime not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("RecordStatus is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("RecordStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Integer value) {
            addCriterion("RecordStatus =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Integer value) {
            addCriterion("RecordStatus <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Integer value) {
            addCriterion("RecordStatus >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecordStatus >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Integer value) {
            addCriterion("RecordStatus <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("RecordStatus <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Integer> values) {
            addCriterion("RecordStatus in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Integer> values) {
            addCriterion("RecordStatus not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("RecordStatus between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("RecordStatus not between", value1, value2, "recordStatus");
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