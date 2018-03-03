package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HireRecentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HireRecentExample() {
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

        public Criteria andHireIdIsNull() {
            addCriterion("HireId is null");
            return (Criteria) this;
        }

        public Criteria andHireIdIsNotNull() {
            addCriterion("HireId is not null");
            return (Criteria) this;
        }

        public Criteria andHireIdEqualTo(Integer value) {
            addCriterion("HireId =", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdNotEqualTo(Integer value) {
            addCriterion("HireId <>", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdGreaterThan(Integer value) {
            addCriterion("HireId >", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HireId >=", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdLessThan(Integer value) {
            addCriterion("HireId <", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdLessThanOrEqualTo(Integer value) {
            addCriterion("HireId <=", value, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdIn(List<Integer> values) {
            addCriterion("HireId in", values, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdNotIn(List<Integer> values) {
            addCriterion("HireId not in", values, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdBetween(Integer value1, Integer value2) {
            addCriterion("HireId between", value1, value2, "hireId");
            return (Criteria) this;
        }

        public Criteria andHireIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HireId not between", value1, value2, "hireId");
            return (Criteria) this;
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

        public Criteria andStaffTitleIdIsNull() {
            addCriterion("StaffTitleId is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdIsNotNull() {
            addCriterion("StaffTitleId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdEqualTo(Integer value) {
            addCriterion("StaffTitleId =", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotEqualTo(Integer value) {
            addCriterion("StaffTitleId <>", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdGreaterThan(Integer value) {
            addCriterion("StaffTitleId >", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleId >=", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdLessThan(Integer value) {
            addCriterion("StaffTitleId <", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleId <=", value, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdIn(List<Integer> values) {
            addCriterion("StaffTitleId in", values, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotIn(List<Integer> values) {
            addCriterion("StaffTitleId not in", values, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleId between", value1, value2, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleId not between", value1, value2, "staffTitleId");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIsNull() {
            addCriterion("StaffTitleName is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIsNotNull() {
            addCriterion("StaffTitleName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameEqualTo(String value) {
            addCriterion("StaffTitleName =", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotEqualTo(String value) {
            addCriterion("StaffTitleName <>", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameGreaterThan(String value) {
            addCriterion("StaffTitleName >", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffTitleName >=", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLessThan(String value) {
            addCriterion("StaffTitleName <", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLessThanOrEqualTo(String value) {
            addCriterion("StaffTitleName <=", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameLike(String value) {
            addCriterion("StaffTitleName like", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotLike(String value) {
            addCriterion("StaffTitleName not like", value, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameIn(List<String> values) {
            addCriterion("StaffTitleName in", values, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotIn(List<String> values) {
            addCriterion("StaffTitleName not in", values, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameBetween(String value1, String value2) {
            addCriterion("StaffTitleName between", value1, value2, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffTitleNameNotBetween(String value1, String value2) {
            addCriterion("StaffTitleName not between", value1, value2, "staffTitleName");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIsNull() {
            addCriterion("StaffPostId is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIsNotNull() {
            addCriterion("StaffPostId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdEqualTo(Integer value) {
            addCriterion("StaffPostId =", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotEqualTo(Integer value) {
            addCriterion("StaffPostId <>", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdGreaterThan(Integer value) {
            addCriterion("StaffPostId >", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffPostId >=", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdLessThan(Integer value) {
            addCriterion("StaffPostId <", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffPostId <=", value, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdIn(List<Integer> values) {
            addCriterion("StaffPostId in", values, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotIn(List<Integer> values) {
            addCriterion("StaffPostId not in", values, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostId between", value1, value2, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostId not between", value1, value2, "staffPostId");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIsNull() {
            addCriterion("StaffPostName is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIsNotNull() {
            addCriterion("StaffPostName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameEqualTo(String value) {
            addCriterion("StaffPostName =", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotEqualTo(String value) {
            addCriterion("StaffPostName <>", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameGreaterThan(String value) {
            addCriterion("StaffPostName >", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffPostName >=", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLessThan(String value) {
            addCriterion("StaffPostName <", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLessThanOrEqualTo(String value) {
            addCriterion("StaffPostName <=", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameLike(String value) {
            addCriterion("StaffPostName like", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotLike(String value) {
            addCriterion("StaffPostName not like", value, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameIn(List<String> values) {
            addCriterion("StaffPostName in", values, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotIn(List<String> values) {
            addCriterion("StaffPostName not in", values, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameBetween(String value1, String value2) {
            addCriterion("StaffPostName between", value1, value2, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffPostNameNotBetween(String value1, String value2) {
            addCriterion("StaffPostName not between", value1, value2, "staffPostName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIsNull() {
            addCriterion("StaffTypeId is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIsNotNull() {
            addCriterion("StaffTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdEqualTo(Integer value) {
            addCriterion("StaffTypeId =", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotEqualTo(Integer value) {
            addCriterion("StaffTypeId <>", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdGreaterThan(Integer value) {
            addCriterion("StaffTypeId >", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTypeId >=", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdLessThan(Integer value) {
            addCriterion("StaffTypeId <", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTypeId <=", value, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdIn(List<Integer> values) {
            addCriterion("StaffTypeId in", values, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotIn(List<Integer> values) {
            addCriterion("StaffTypeId not in", values, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffTypeId between", value1, value2, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTypeId not between", value1, value2, "staffTypeId");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIsNull() {
            addCriterion("StaffTypeName is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIsNotNull() {
            addCriterion("StaffTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameEqualTo(String value) {
            addCriterion("StaffTypeName =", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotEqualTo(String value) {
            addCriterion("StaffTypeName <>", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameGreaterThan(String value) {
            addCriterion("StaffTypeName >", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffTypeName >=", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLessThan(String value) {
            addCriterion("StaffTypeName <", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLessThanOrEqualTo(String value) {
            addCriterion("StaffTypeName <=", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameLike(String value) {
            addCriterion("StaffTypeName like", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotLike(String value) {
            addCriterion("StaffTypeName not like", value, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameIn(List<String> values) {
            addCriterion("StaffTypeName in", values, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotIn(List<String> values) {
            addCriterion("StaffTypeName not in", values, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameBetween(String value1, String value2) {
            addCriterion("StaffTypeName between", value1, value2, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNameNotBetween(String value1, String value2) {
            addCriterion("StaffTypeName not between", value1, value2, "staffTypeName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIsNull() {
            addCriterion("StaffStatusId is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIsNotNull() {
            addCriterion("StaffStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdEqualTo(Integer value) {
            addCriterion("StaffStatusId =", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotEqualTo(Integer value) {
            addCriterion("StaffStatusId <>", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdGreaterThan(Integer value) {
            addCriterion("StaffStatusId >", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffStatusId >=", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdLessThan(Integer value) {
            addCriterion("StaffStatusId <", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffStatusId <=", value, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdIn(List<Integer> values) {
            addCriterion("StaffStatusId in", values, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotIn(List<Integer> values) {
            addCriterion("StaffStatusId not in", values, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffStatusId between", value1, value2, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffStatusId not between", value1, value2, "staffStatusId");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIsNull() {
            addCriterion("StaffStatusName is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIsNotNull() {
            addCriterion("StaffStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameEqualTo(String value) {
            addCriterion("StaffStatusName =", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotEqualTo(String value) {
            addCriterion("StaffStatusName <>", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameGreaterThan(String value) {
            addCriterion("StaffStatusName >", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffStatusName >=", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLessThan(String value) {
            addCriterion("StaffStatusName <", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLessThanOrEqualTo(String value) {
            addCriterion("StaffStatusName <=", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameLike(String value) {
            addCriterion("StaffStatusName like", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotLike(String value) {
            addCriterion("StaffStatusName not like", value, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameIn(List<String> values) {
            addCriterion("StaffStatusName in", values, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotIn(List<String> values) {
            addCriterion("StaffStatusName not in", values, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameBetween(String value1, String value2) {
            addCriterion("StaffStatusName between", value1, value2, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNameNotBetween(String value1, String value2) {
            addCriterion("StaffStatusName not between", value1, value2, "staffStatusName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIsNull() {
            addCriterion("StaffDeptId is null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIsNotNull() {
            addCriterion("StaffDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdEqualTo(Integer value) {
            addCriterion("StaffDeptId =", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotEqualTo(Integer value) {
            addCriterion("StaffDeptId <>", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdGreaterThan(Integer value) {
            addCriterion("StaffDeptId >", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffDeptId >=", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdLessThan(Integer value) {
            addCriterion("StaffDeptId <", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("StaffDeptId <=", value, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdIn(List<Integer> values) {
            addCriterion("StaffDeptId in", values, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotIn(List<Integer> values) {
            addCriterion("StaffDeptId not in", values, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("StaffDeptId between", value1, value2, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffDeptId not between", value1, value2, "staffDeptId");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIsNull() {
            addCriterion("StaffDeptName is null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIsNotNull() {
            addCriterion("StaffDeptName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameEqualTo(String value) {
            addCriterion("StaffDeptName =", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotEqualTo(String value) {
            addCriterion("StaffDeptName <>", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameGreaterThan(String value) {
            addCriterion("StaffDeptName >", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffDeptName >=", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLessThan(String value) {
            addCriterion("StaffDeptName <", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLessThanOrEqualTo(String value) {
            addCriterion("StaffDeptName <=", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameLike(String value) {
            addCriterion("StaffDeptName like", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotLike(String value) {
            addCriterion("StaffDeptName not like", value, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameIn(List<String> values) {
            addCriterion("StaffDeptName in", values, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotIn(List<String> values) {
            addCriterion("StaffDeptName not in", values, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameBetween(String value1, String value2) {
            addCriterion("StaffDeptName between", value1, value2, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffDeptNameNotBetween(String value1, String value2) {
            addCriterion("StaffDeptName not between", value1, value2, "staffDeptName");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIsNull() {
            addCriterion("StaffPostVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIsNotNull() {
            addCriterion("StaffPostVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPostValEqualTo(Integer value) {
            addCriterion("StaffPostVal =", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotEqualTo(Integer value) {
            addCriterion("StaffPostVal <>", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValGreaterThan(Integer value) {
            addCriterion("StaffPostVal >", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffPostVal >=", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValLessThan(Integer value) {
            addCriterion("StaffPostVal <", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffPostVal <=", value, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValIn(List<Integer> values) {
            addCriterion("StaffPostVal in", values, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotIn(List<Integer> values) {
            addCriterion("StaffPostVal not in", values, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostVal between", value1, value2, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffPostValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffPostVal not between", value1, value2, "staffPostVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIsNull() {
            addCriterion("StaffTitleVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIsNotNull() {
            addCriterion("StaffTitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValEqualTo(Integer value) {
            addCriterion("StaffTitleVal =", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotEqualTo(Integer value) {
            addCriterion("StaffTitleVal <>", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValGreaterThan(Integer value) {
            addCriterion("StaffTitleVal >", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleVal >=", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValLessThan(Integer value) {
            addCriterion("StaffTitleVal <", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffTitleVal <=", value, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValIn(List<Integer> values) {
            addCriterion("StaffTitleVal in", values, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotIn(List<Integer> values) {
            addCriterion("StaffTitleVal not in", values, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleVal between", value1, value2, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTitleValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffTitleVal not between", value1, value2, "staffTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIsNull() {
            addCriterion("StaffSpousePostVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIsNotNull() {
            addCriterion("StaffSpousePostVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal =", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal <>", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValGreaterThan(Integer value) {
            addCriterion("StaffSpousePostVal >", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal >=", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValLessThan(Integer value) {
            addCriterion("StaffSpousePostVal <", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpousePostVal <=", value, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValIn(List<Integer> values) {
            addCriterion("StaffSpousePostVal in", values, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotIn(List<Integer> values) {
            addCriterion("StaffSpousePostVal not in", values, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpousePostVal between", value1, value2, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpousePostValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpousePostVal not between", value1, value2, "staffSpousePostVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIsNull() {
            addCriterion("StaffSpouseTitleVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIsNotNull() {
            addCriterion("StaffSpouseTitleVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal =", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal <>", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValGreaterThan(Integer value) {
            addCriterion("StaffSpouseTitleVal >", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal >=", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValLessThan(Integer value) {
            addCriterion("StaffSpouseTitleVal <", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValLessThanOrEqualTo(Integer value) {
            addCriterion("StaffSpouseTitleVal <=", value, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValIn(List<Integer> values) {
            addCriterion("StaffSpouseTitleVal in", values, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotIn(List<Integer> values) {
            addCriterion("StaffSpouseTitleVal not in", values, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseTitleVal between", value1, value2, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseTitleValNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffSpouseTitleVal not between", value1, value2, "staffSpouseTitleVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValIsNull() {
            addCriterion("StaffTimeVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValIsNotNull() {
            addCriterion("StaffTimeVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValEqualTo(Double value) {
            addCriterion("StaffTimeVal =", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValNotEqualTo(Double value) {
            addCriterion("StaffTimeVal <>", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValGreaterThan(Double value) {
            addCriterion("StaffTimeVal >", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValGreaterThanOrEqualTo(Double value) {
            addCriterion("StaffTimeVal >=", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValLessThan(Double value) {
            addCriterion("StaffTimeVal <", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValLessThanOrEqualTo(Double value) {
            addCriterion("StaffTimeVal <=", value, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValIn(List<Double> values) {
            addCriterion("StaffTimeVal in", values, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValNotIn(List<Double> values) {
            addCriterion("StaffTimeVal not in", values, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValBetween(Double value1, Double value2) {
            addCriterion("StaffTimeVal between", value1, value2, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffTimeValNotBetween(Double value1, Double value2) {
            addCriterion("StaffTimeVal not between", value1, value2, "staffTimeVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValIsNull() {
            addCriterion("StaffOtherVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValIsNotNull() {
            addCriterion("StaffOtherVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValEqualTo(Double value) {
            addCriterion("StaffOtherVal =", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValNotEqualTo(Double value) {
            addCriterion("StaffOtherVal <>", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValGreaterThan(Double value) {
            addCriterion("StaffOtherVal >", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValGreaterThanOrEqualTo(Double value) {
            addCriterion("StaffOtherVal >=", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValLessThan(Double value) {
            addCriterion("StaffOtherVal <", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValLessThanOrEqualTo(Double value) {
            addCriterion("StaffOtherVal <=", value, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValIn(List<Double> values) {
            addCriterion("StaffOtherVal in", values, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValNotIn(List<Double> values) {
            addCriterion("StaffOtherVal not in", values, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValBetween(Double value1, Double value2) {
            addCriterion("StaffOtherVal between", value1, value2, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffOtherValNotBetween(Double value1, Double value2) {
            addCriterion("StaffOtherVal not between", value1, value2, "staffOtherVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValIsNull() {
            addCriterion("StaffTotalVal is null");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValIsNotNull() {
            addCriterion("StaffTotalVal is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValEqualTo(Double value) {
            addCriterion("StaffTotalVal =", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValNotEqualTo(Double value) {
            addCriterion("StaffTotalVal <>", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValGreaterThan(Double value) {
            addCriterion("StaffTotalVal >", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValGreaterThanOrEqualTo(Double value) {
            addCriterion("StaffTotalVal >=", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValLessThan(Double value) {
            addCriterion("StaffTotalVal <", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValLessThanOrEqualTo(Double value) {
            addCriterion("StaffTotalVal <=", value, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValIn(List<Double> values) {
            addCriterion("StaffTotalVal in", values, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValNotIn(List<Double> values) {
            addCriterion("StaffTotalVal not in", values, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValBetween(Double value1, Double value2) {
            addCriterion("StaffTotalVal between", value1, value2, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffTotalValNotBetween(Double value1, Double value2) {
            addCriterion("StaffTotalVal not between", value1, value2, "staffTotalVal");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartIsNull() {
            addCriterion("StaffSelectStart is null");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartIsNotNull() {
            addCriterion("StaffSelectStart is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartEqualTo(Date value) {
            addCriterion("StaffSelectStart =", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartNotEqualTo(Date value) {
            addCriterion("StaffSelectStart <>", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartGreaterThan(Date value) {
            addCriterion("StaffSelectStart >", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartGreaterThanOrEqualTo(Date value) {
            addCriterion("StaffSelectStart >=", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartLessThan(Date value) {
            addCriterion("StaffSelectStart <", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartLessThanOrEqualTo(Date value) {
            addCriterion("StaffSelectStart <=", value, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartIn(List<Date> values) {
            addCriterion("StaffSelectStart in", values, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartNotIn(List<Date> values) {
            addCriterion("StaffSelectStart not in", values, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartBetween(Date value1, Date value2) {
            addCriterion("StaffSelectStart between", value1, value2, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectStartNotBetween(Date value1, Date value2) {
            addCriterion("StaffSelectStart not between", value1, value2, "staffSelectStart");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndIsNull() {
            addCriterion("StaffSelectEnd is null");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndIsNotNull() {
            addCriterion("StaffSelectEnd is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndEqualTo(Date value) {
            addCriterion("StaffSelectEnd =", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndNotEqualTo(Date value) {
            addCriterion("StaffSelectEnd <>", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndGreaterThan(Date value) {
            addCriterion("StaffSelectEnd >", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndGreaterThanOrEqualTo(Date value) {
            addCriterion("StaffSelectEnd >=", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndLessThan(Date value) {
            addCriterion("StaffSelectEnd <", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndLessThanOrEqualTo(Date value) {
            addCriterion("StaffSelectEnd <=", value, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndIn(List<Date> values) {
            addCriterion("StaffSelectEnd in", values, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndNotIn(List<Date> values) {
            addCriterion("StaffSelectEnd not in", values, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndBetween(Date value1, Date value2) {
            addCriterion("StaffSelectEnd between", value1, value2, "staffSelectEnd");
            return (Criteria) this;
        }

        public Criteria andStaffSelectEndNotBetween(Date value1, Date value2) {
            addCriterion("StaffSelectEnd not between", value1, value2, "staffSelectEnd");
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

        public Criteria andHouseNoIsNull() {
            addCriterion("HouseNo is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("HouseNo is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("HouseNo =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("HouseNo <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("HouseNo >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("HouseNo >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("HouseNo <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("HouseNo <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("HouseNo like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("HouseNo not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("HouseNo in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("HouseNo not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("HouseNo between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("HouseNo not between", value1, value2, "houseNo");
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

        public Criteria andHouseAddressIsNull() {
            addCriterion("HouseAddress is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNotNull() {
            addCriterion("HouseAddress is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressEqualTo(String value) {
            addCriterion("HouseAddress =", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotEqualTo(String value) {
            addCriterion("HouseAddress <>", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThan(String value) {
            addCriterion("HouseAddress >", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("HouseAddress >=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThan(String value) {
            addCriterion("HouseAddress <", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThanOrEqualTo(String value) {
            addCriterion("HouseAddress <=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLike(String value) {
            addCriterion("HouseAddress like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotLike(String value) {
            addCriterion("HouseAddress not like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIn(List<String> values) {
            addCriterion("HouseAddress in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotIn(List<String> values) {
            addCriterion("HouseAddress not in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressBetween(String value1, String value2) {
            addCriterion("HouseAddress between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotBetween(String value1, String value2) {
            addCriterion("HouseAddress not between", value1, value2, "houseAddress");
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