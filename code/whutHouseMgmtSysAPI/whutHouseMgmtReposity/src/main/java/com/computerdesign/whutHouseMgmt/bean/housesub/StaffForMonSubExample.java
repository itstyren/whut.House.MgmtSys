package com.computerdesign.whutHouseMgmt.bean.housesub;

import java.util.ArrayList;
import java.util.List;

public class StaffForMonSubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffForMonSubExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("StaffId is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("StaffId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("StaffId =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("StaffId <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("StaffId >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffId >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("StaffId <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffId <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("StaffId in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("StaffId not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffId between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffId not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("StaffNo is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("StaffNo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(String value) {
            addCriterion("StaffNo =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(String value) {
            addCriterion("StaffNo <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(String value) {
            addCriterion("StaffNo >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("StaffNo >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(String value) {
            addCriterion("StaffNo <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(String value) {
            addCriterion("StaffNo <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLike(String value) {
            addCriterion("StaffNo like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotLike(String value) {
            addCriterion("StaffNo not like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<String> values) {
            addCriterion("StaffNo in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<String> values) {
            addCriterion("StaffNo not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(String value1, String value2) {
            addCriterion("StaffNo between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(String value1, String value2) {
            addCriterion("StaffNo not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("StaffName is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("StaffName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("StaffName =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("StaffName <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("StaffName >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffName >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("StaffName <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("StaffName <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("StaffName like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("StaffName not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("StaffName in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("StaffName not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("StaffName between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("StaffName not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNull() {
            addCriterion("TitleId is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("TitleId is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(Integer value) {
            addCriterion("TitleId =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(Integer value) {
            addCriterion("TitleId <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(Integer value) {
            addCriterion("TitleId >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TitleId >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(Integer value) {
            addCriterion("TitleId <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("TitleId <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<Integer> values) {
            addCriterion("TitleId in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<Integer> values) {
            addCriterion("TitleId not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("TitleId between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TitleId not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNull() {
            addCriterion("TitleName is null");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNotNull() {
            addCriterion("TitleName is not null");
            return (Criteria) this;
        }

        public Criteria andTitleNameEqualTo(String value) {
            addCriterion("TitleName =", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotEqualTo(String value) {
            addCriterion("TitleName <>", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThan(String value) {
            addCriterion("TitleName >", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("TitleName >=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThan(String value) {
            addCriterion("TitleName <", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThanOrEqualTo(String value) {
            addCriterion("TitleName <=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLike(String value) {
            addCriterion("TitleName like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotLike(String value) {
            addCriterion("TitleName not like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIn(List<String> values) {
            addCriterion("TitleName in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotIn(List<String> values) {
            addCriterion("TitleName not in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameBetween(String value1, String value2) {
            addCriterion("TitleName between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotBetween(String value1, String value2) {
            addCriterion("TitleName not between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIsNull() {
            addCriterion("TitleArea is null");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIsNotNull() {
            addCriterion("TitleArea is not null");
            return (Criteria) this;
        }

        public Criteria andTitleAreaEqualTo(Float value) {
            addCriterion("TitleArea =", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotEqualTo(Float value) {
            addCriterion("TitleArea <>", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaGreaterThan(Float value) {
            addCriterion("TitleArea >", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("TitleArea >=", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaLessThan(Float value) {
            addCriterion("TitleArea <", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaLessThanOrEqualTo(Float value) {
            addCriterion("TitleArea <=", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIn(List<Float> values) {
            addCriterion("TitleArea in", values, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotIn(List<Float> values) {
            addCriterion("TitleArea not in", values, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaBetween(Float value1, Float value2) {
            addCriterion("TitleArea between", value1, value2, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotBetween(Float value1, Float value2) {
            addCriterion("TitleArea not between", value1, value2, "titleArea");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("PostId is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("PostId is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("PostId =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("PostId <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("PostId >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PostId >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("PostId <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("PostId <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("PostId in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("PostId not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("PostId between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PostId not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNull() {
            addCriterion("PostName is null");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNotNull() {
            addCriterion("PostName is not null");
            return (Criteria) this;
        }

        public Criteria andPostNameEqualTo(String value) {
            addCriterion("PostName =", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotEqualTo(String value) {
            addCriterion("PostName <>", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThan(String value) {
            addCriterion("PostName >", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("PostName >=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThan(String value) {
            addCriterion("PostName <", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThanOrEqualTo(String value) {
            addCriterion("PostName <=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLike(String value) {
            addCriterion("PostName like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotLike(String value) {
            addCriterion("PostName not like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameIn(List<String> values) {
            addCriterion("PostName in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotIn(List<String> values) {
            addCriterion("PostName not in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameBetween(String value1, String value2) {
            addCriterion("PostName between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotBetween(String value1, String value2) {
            addCriterion("PostName not between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostAreaIsNull() {
            addCriterion("PostArea is null");
            return (Criteria) this;
        }

        public Criteria andPostAreaIsNotNull() {
            addCriterion("PostArea is not null");
            return (Criteria) this;
        }

        public Criteria andPostAreaEqualTo(Float value) {
            addCriterion("PostArea =", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaNotEqualTo(Float value) {
            addCriterion("PostArea <>", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaGreaterThan(Float value) {
            addCriterion("PostArea >", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("PostArea >=", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaLessThan(Float value) {
            addCriterion("PostArea <", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaLessThanOrEqualTo(Float value) {
            addCriterion("PostArea <=", value, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaIn(List<Float> values) {
            addCriterion("PostArea in", values, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaNotIn(List<Float> values) {
            addCriterion("PostArea not in", values, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaBetween(Float value1, Float value2) {
            addCriterion("PostArea between", value1, value2, "postArea");
            return (Criteria) this;
        }

        public Criteria andPostAreaNotBetween(Float value1, Float value2) {
            addCriterion("PostArea not between", value1, value2, "postArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaIsNull() {
            addCriterion("MaxEnjoyArea is null");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaIsNotNull() {
            addCriterion("MaxEnjoyArea is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaEqualTo(Double value) {
            addCriterion("MaxEnjoyArea =", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaNotEqualTo(Double value) {
            addCriterion("MaxEnjoyArea <>", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaGreaterThan(Double value) {
            addCriterion("MaxEnjoyArea >", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("MaxEnjoyArea >=", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaLessThan(Double value) {
            addCriterion("MaxEnjoyArea <", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaLessThanOrEqualTo(Double value) {
            addCriterion("MaxEnjoyArea <=", value, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaIn(List<Double> values) {
            addCriterion("MaxEnjoyArea in", values, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaNotIn(List<Double> values) {
            addCriterion("MaxEnjoyArea not in", values, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaBetween(Double value1, Double value2) {
            addCriterion("MaxEnjoyArea between", value1, value2, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andMaxEnjoyAreaNotBetween(Double value1, Double value2) {
            addCriterion("MaxEnjoyArea not between", value1, value2, "maxEnjoyArea");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("HouseId is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("HouseId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("HouseId =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("HouseId <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("HouseId >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseId >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("HouseId <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseId <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("HouseId in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("HouseId not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseId between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseId not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNull() {
            addCriterion("HouseBuildArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIsNotNull() {
            addCriterion("HouseBuildArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaEqualTo(Double value) {
            addCriterion("HouseBuildArea =", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotEqualTo(Double value) {
            addCriterion("HouseBuildArea <>", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThan(Double value) {
            addCriterion("HouseBuildArea >", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea >=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThan(Double value) {
            addCriterion("HouseBuildArea <", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseBuildArea <=", value, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaIn(List<Double> values) {
            addCriterion("HouseBuildArea in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotIn(List<Double> values) {
            addCriterion("HouseBuildArea not in", values, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseBuildAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseBuildArea not between", value1, value2, "houseBuildArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaIsNull() {
            addCriterion("HouseUsedArea is null");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaIsNotNull() {
            addCriterion("HouseUsedArea is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaEqualTo(Double value) {
            addCriterion("HouseUsedArea =", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotEqualTo(Double value) {
            addCriterion("HouseUsedArea <>", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaGreaterThan(Double value) {
            addCriterion("HouseUsedArea >", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("HouseUsedArea >=", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaLessThan(Double value) {
            addCriterion("HouseUsedArea <", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaLessThanOrEqualTo(Double value) {
            addCriterion("HouseUsedArea <=", value, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaIn(List<Double> values) {
            addCriterion("HouseUsedArea in", values, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotIn(List<Double> values) {
            addCriterion("HouseUsedArea not in", values, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaBetween(Double value1, Double value2) {
            addCriterion("HouseUsedArea between", value1, value2, "houseUsedArea");
            return (Criteria) this;
        }

        public Criteria andHouseUsedAreaNotBetween(Double value1, Double value2) {
            addCriterion("HouseUsedArea not between", value1, value2, "houseUsedArea");
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