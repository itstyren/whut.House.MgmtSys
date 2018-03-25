package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

import java.util.ArrayList;
import java.util.List;

public class StaffValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffValueExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
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

        public Criteria andStaffTitleValueIsNull() {
            addCriterion("StaffTitleValue is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueIsNotNull() {
            addCriterion("StaffTitleValue is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueEqualTo(Integer value) {
            addCriterion("StaffTitleValue =", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueNotEqualTo(Integer value) {
            addCriterion("StaffTitleValue <>", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueGreaterThan(Integer value) {
            addCriterion("StaffTitleValue >", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleValue >=", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueLessThan(Integer value) {
            addCriterion("StaffTitleValue <", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleValue <=", value, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueIn(List<Integer> values) {
            addCriterion("StaffTitleValue in", values, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueNotIn(List<Integer> values) {
            addCriterion("StaffTitleValue not in", values, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleValue between", value1, value2, "staffTitleValue");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValueNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleValue not between", value1, value2, "staffTitleValue");
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

        public Criteria andStaffPostValueIsNull() {
            addCriterion("StaffPostValue is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueIsNotNull() {
            addCriterion("StaffPostValue is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueEqualTo(Integer value) {
            addCriterion("StaffPostValue =", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueNotEqualTo(Integer value) {
            addCriterion("StaffPostValue <>", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueGreaterThan(Integer value) {
            addCriterion("StaffPostValue >", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffPostValue >=", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueLessThan(Integer value) {
            addCriterion("StaffPostValue <", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueLessThanOrEqualTo(Integer value) {
            addCriterion("StaffPostValue <=", value, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueIn(List<Integer> values) {
            addCriterion("StaffPostValue in", values, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueNotIn(List<Integer> values) {
            addCriterion("StaffPostValue not in", values, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostValue between", value1, value2, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andStaffPostValueNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostValue not between", value1, value2, "staffPostValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdIsNull() {
            addCriterion("SpouseTitleId is null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdIsNotNull() {
            addCriterion("SpouseTitleId is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdEqualTo(Integer value) {
            addCriterion("SpouseTitleId =", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdNotEqualTo(Integer value) {
            addCriterion("SpouseTitleId <>", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdGreaterThan(Integer value) {
            addCriterion("SpouseTitleId >", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleId >=", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdLessThan(Integer value) {
            addCriterion("SpouseTitleId <", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleId <=", value, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdIn(List<Integer> values) {
            addCriterion("SpouseTitleId in", values, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdNotIn(List<Integer> values) {
            addCriterion("SpouseTitleId not in", values, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleId between", value1, value2, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleId not between", value1, value2, "spouseTitleId");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameIsNull() {
            addCriterion("SpouseTitleName is null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameIsNotNull() {
            addCriterion("SpouseTitleName is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameEqualTo(String value) {
            addCriterion("SpouseTitleName =", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameNotEqualTo(String value) {
            addCriterion("SpouseTitleName <>", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameGreaterThan(String value) {
            addCriterion("SpouseTitleName >", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("SpouseTitleName >=", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameLessThan(String value) {
            addCriterion("SpouseTitleName <", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameLessThanOrEqualTo(String value) {
            addCriterion("SpouseTitleName <=", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameLike(String value) {
            addCriterion("SpouseTitleName like", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameNotLike(String value) {
            addCriterion("SpouseTitleName not like", value, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameIn(List<String> values) {
            addCriterion("SpouseTitleName in", values, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameNotIn(List<String> values) {
            addCriterion("SpouseTitleName not in", values, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameBetween(String value1, String value2) {
            addCriterion("SpouseTitleName between", value1, value2, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleNameNotBetween(String value1, String value2) {
            addCriterion("SpouseTitleName not between", value1, value2, "spouseTitleName");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueIsNull() {
            addCriterion("SpouseTitleValue is null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueIsNotNull() {
            addCriterion("SpouseTitleValue is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueEqualTo(Integer value) {
            addCriterion("SpouseTitleValue =", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueNotEqualTo(Integer value) {
            addCriterion("SpouseTitleValue <>", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueGreaterThan(Integer value) {
            addCriterion("SpouseTitleValue >", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleValue >=", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueLessThan(Integer value) {
            addCriterion("SpouseTitleValue <", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueLessThanOrEqualTo(Integer value) {
            addCriterion("SpouseTitleValue <=", value, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueIn(List<Integer> values) {
            addCriterion("SpouseTitleValue in", values, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueNotIn(List<Integer> values) {
            addCriterion("SpouseTitleValue not in", values, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleValue between", value1, value2, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpouseTitleValueNotBetween(Integer value1, Integer value2) {
            addCriterion("SpouseTitleValue not between", value1, value2, "spouseTitleValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdIsNull() {
            addCriterion("SpousePostId is null");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdIsNotNull() {
            addCriterion("SpousePostId is not null");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdEqualTo(Integer value) {
            addCriterion("SpousePostId =", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdNotEqualTo(Integer value) {
            addCriterion("SpousePostId <>", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdGreaterThan(Integer value) {
            addCriterion("SpousePostId >", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpousePostId >=", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdLessThan(Integer value) {
            addCriterion("SpousePostId <", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdLessThanOrEqualTo(Integer value) {
            addCriterion("SpousePostId <=", value, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdIn(List<Integer> values) {
            addCriterion("SpousePostId in", values, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdNotIn(List<Integer> values) {
            addCriterion("SpousePostId not in", values, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostId between", value1, value2, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostId not between", value1, value2, "spousePostId");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameIsNull() {
            addCriterion("SpousePostName is null");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameIsNotNull() {
            addCriterion("SpousePostName is not null");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameEqualTo(String value) {
            addCriterion("SpousePostName =", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameNotEqualTo(String value) {
            addCriterion("SpousePostName <>", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameGreaterThan(String value) {
            addCriterion("SpousePostName >", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameGreaterThanOrEqualTo(String value) {
            addCriterion("SpousePostName >=", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameLessThan(String value) {
            addCriterion("SpousePostName <", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameLessThanOrEqualTo(String value) {
            addCriterion("SpousePostName <=", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameLike(String value) {
            addCriterion("SpousePostName like", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameNotLike(String value) {
            addCriterion("SpousePostName not like", value, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameIn(List<String> values) {
            addCriterion("SpousePostName in", values, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameNotIn(List<String> values) {
            addCriterion("SpousePostName not in", values, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameBetween(String value1, String value2) {
            addCriterion("SpousePostName between", value1, value2, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostNameNotBetween(String value1, String value2) {
            addCriterion("SpousePostName not between", value1, value2, "spousePostName");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueIsNull() {
            addCriterion("SpousePostValue is null");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueIsNotNull() {
            addCriterion("SpousePostValue is not null");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueEqualTo(Integer value) {
            addCriterion("SpousePostValue =", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueNotEqualTo(Integer value) {
            addCriterion("SpousePostValue <>", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueGreaterThan(Integer value) {
            addCriterion("SpousePostValue >", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpousePostValue >=", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueLessThan(Integer value) {
            addCriterion("SpousePostValue <", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueLessThanOrEqualTo(Integer value) {
            addCriterion("SpousePostValue <=", value, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueIn(List<Integer> values) {
            addCriterion("SpousePostValue in", values, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueNotIn(List<Integer> values) {
            addCriterion("SpousePostValue not in", values, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostValue between", value1, value2, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andSpousePostValueNotBetween(Integer value1, Integer value2) {
            addCriterion("SpousePostValue not between", value1, value2, "spousePostValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueIsNull() {
            addCriterion("OtherValue is null");
            return (Criteria) this;
        }

        public Criteria andOtherValueIsNotNull() {
            addCriterion("OtherValue is not null");
            return (Criteria) this;
        }

        public Criteria andOtherValueEqualTo(Double value) {
            addCriterion("OtherValue =", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueNotEqualTo(Double value) {
            addCriterion("OtherValue <>", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueGreaterThan(Double value) {
            addCriterion("OtherValue >", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueGreaterThanOrEqualTo(Double value) {
            addCriterion("OtherValue >=", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueLessThan(Double value) {
            addCriterion("OtherValue <", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueLessThanOrEqualTo(Double value) {
            addCriterion("OtherValue <=", value, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueIn(List<Double> values) {
            addCriterion("OtherValue in", values, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueNotIn(List<Double> values) {
            addCriterion("OtherValue not in", values, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueBetween(Double value1, Double value2) {
            addCriterion("OtherValue between", value1, value2, "otherValue");
            return (Criteria) this;
        }

        public Criteria andOtherValueNotBetween(Double value1, Double value2) {
            addCriterion("OtherValue not between", value1, value2, "otherValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueIsNull() {
            addCriterion("TimeValue is null");
            return (Criteria) this;
        }

        public Criteria andTimeValueIsNotNull() {
            addCriterion("TimeValue is not null");
            return (Criteria) this;
        }

        public Criteria andTimeValueEqualTo(Double value) {
            addCriterion("TimeValue =", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueNotEqualTo(Double value) {
            addCriterion("TimeValue <>", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueGreaterThan(Double value) {
            addCriterion("TimeValue >", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueGreaterThanOrEqualTo(Double value) {
            addCriterion("TimeValue >=", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueLessThan(Double value) {
            addCriterion("TimeValue <", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueLessThanOrEqualTo(Double value) {
            addCriterion("TimeValue <=", value, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueIn(List<Double> values) {
            addCriterion("TimeValue in", values, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueNotIn(List<Double> values) {
            addCriterion("TimeValue not in", values, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueBetween(Double value1, Double value2) {
            addCriterion("TimeValue between", value1, value2, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTimeValueNotBetween(Double value1, Double value2) {
            addCriterion("TimeValue not between", value1, value2, "timeValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueIsNull() {
            addCriterion("TotalValue is null");
            return (Criteria) this;
        }

        public Criteria andTotalValueIsNotNull() {
            addCriterion("TotalValue is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValueEqualTo(Double value) {
            addCriterion("TotalValue =", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotEqualTo(Double value) {
            addCriterion("TotalValue <>", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueGreaterThan(Double value) {
            addCriterion("TotalValue >", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueGreaterThanOrEqualTo(Double value) {
            addCriterion("TotalValue >=", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueLessThan(Double value) {
            addCriterion("TotalValue <", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueLessThanOrEqualTo(Double value) {
            addCriterion("TotalValue <=", value, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueIn(List<Double> values) {
            addCriterion("TotalValue in", values, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotIn(List<Double> values) {
            addCriterion("TotalValue not in", values, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueBetween(Double value1, Double value2) {
            addCriterion("TotalValue between", value1, value2, "totalValue");
            return (Criteria) this;
        }

        public Criteria andTotalValueNotBetween(Double value1, Double value2) {
            addCriterion("TotalValue not between", value1, value2, "totalValue");
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