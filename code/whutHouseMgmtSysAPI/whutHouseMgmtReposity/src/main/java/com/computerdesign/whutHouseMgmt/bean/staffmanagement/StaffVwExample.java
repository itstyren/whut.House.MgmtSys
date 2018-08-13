package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StaffVwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffVwExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("Sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("Sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andMarriageStateIsNull() {
            addCriterion("MarriageState is null");
            return (Criteria) this;
        }

        public Criteria andMarriageStateIsNotNull() {
            addCriterion("MarriageState is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageStateEqualTo(String value) {
            addCriterion("MarriageState =", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateNotEqualTo(String value) {
            addCriterion("MarriageState <>", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateGreaterThan(String value) {
            addCriterion("MarriageState >", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateGreaterThanOrEqualTo(String value) {
            addCriterion("MarriageState >=", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateLessThan(String value) {
            addCriterion("MarriageState <", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateLessThanOrEqualTo(String value) {
            addCriterion("MarriageState <=", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateLike(String value) {
            addCriterion("MarriageState like", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateNotLike(String value) {
            addCriterion("MarriageState not like", value, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateIn(List<String> values) {
            addCriterion("MarriageState in", values, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateNotIn(List<String> values) {
            addCriterion("MarriageState not in", values, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateBetween(String value1, String value2) {
            addCriterion("MarriageState between", value1, value2, "marriageState");
            return (Criteria) this;
        }

        public Criteria andMarriageStateNotBetween(String value1, String value2) {
            addCriterion("MarriageState not between", value1, value2, "marriageState");
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

        public Criteria andTypeIdIsNull() {
            addCriterion("TypeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TypeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("TypeId =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("TypeId <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("TypeId >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TypeId >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("TypeId <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("TypeId <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("TypeId in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("TypeId not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("TypeId between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TypeId not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("TypeName is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TypeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TypeName =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TypeName <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TypeName >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TypeName >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TypeName <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TypeName <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TypeName like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TypeName not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TypeName in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TypeName not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TypeName between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TypeName not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNull() {
            addCriterion("StatusId is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("StatusId is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(Integer value) {
            addCriterion("StatusId =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Integer value) {
            addCriterion("StatusId <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Integer value) {
            addCriterion("StatusId >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StatusId >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Integer value) {
            addCriterion("StatusId <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Integer value) {
            addCriterion("StatusId <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Integer> values) {
            addCriterion("StatusId in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Integer> values) {
            addCriterion("StatusId not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Integer value1, Integer value2) {
            addCriterion("StatusId between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StatusId not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNull() {
            addCriterion("StatusName is null");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNotNull() {
            addCriterion("StatusName is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNameEqualTo(String value) {
            addCriterion("StatusName =", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotEqualTo(String value) {
            addCriterion("StatusName <>", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThan(String value) {
            addCriterion("StatusName >", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("StatusName >=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThan(String value) {
            addCriterion("StatusName <", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThanOrEqualTo(String value) {
            addCriterion("StatusName <=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLike(String value) {
            addCriterion("StatusName like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotLike(String value) {
            addCriterion("StatusName not like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIn(List<String> values) {
            addCriterion("StatusName in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotIn(List<String> values) {
            addCriterion("StatusName not in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameBetween(String value1, String value2) {
            addCriterion("StatusName between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotBetween(String value1, String value2) {
            addCriterion("StatusName not between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("deptId is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("deptId is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("deptId =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("deptId <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("deptId >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deptId >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("deptId <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("deptId <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("deptId in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("deptId not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("deptId between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deptId not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DeptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DeptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DeptName =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DeptName <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DeptName >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DeptName >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DeptName <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DeptName <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DeptName like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DeptName not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DeptName in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DeptName not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DeptName between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DeptName not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("Code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("Code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("Code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("Code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("Code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("Code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("Code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("Code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("Code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("Code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("Code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("Code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("Code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsIsNull() {
            addCriterion("EduQualifications is null");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsIsNotNull() {
            addCriterion("EduQualifications is not null");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsEqualTo(String value) {
            addCriterion("EduQualifications =", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsNotEqualTo(String value) {
            addCriterion("EduQualifications <>", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsGreaterThan(String value) {
            addCriterion("EduQualifications >", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsGreaterThanOrEqualTo(String value) {
            addCriterion("EduQualifications >=", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsLessThan(String value) {
            addCriterion("EduQualifications <", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsLessThanOrEqualTo(String value) {
            addCriterion("EduQualifications <=", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsLike(String value) {
            addCriterion("EduQualifications like", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsNotLike(String value) {
            addCriterion("EduQualifications not like", value, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsIn(List<String> values) {
            addCriterion("EduQualifications in", values, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsNotIn(List<String> values) {
            addCriterion("EduQualifications not in", values, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsBetween(String value1, String value2) {
            addCriterion("EduQualifications between", value1, value2, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andEduQualificationsNotBetween(String value1, String value2) {
            addCriterion("EduQualifications not between", value1, value2, "eduQualifications");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("JoinTime is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("JoinTime is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Date value) {
            addCriterionForJDBCDate("JoinTime =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("JoinTime <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("JoinTime >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("JoinTime >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Date value) {
            addCriterionForJDBCDate("JoinTime <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("JoinTime <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Date> values) {
            addCriterionForJDBCDate("JoinTime in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("JoinTime not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("JoinTime between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("JoinTime not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeIsNull() {
            addCriterion("RetireTime is null");
            return (Criteria) this;
        }

        public Criteria andRetireTimeIsNotNull() {
            addCriterion("RetireTime is not null");
            return (Criteria) this;
        }

        public Criteria andRetireTimeEqualTo(Date value) {
            addCriterionForJDBCDate("RetireTime =", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("RetireTime <>", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("RetireTime >", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RetireTime >=", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeLessThan(Date value) {
            addCriterionForJDBCDate("RetireTime <", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RetireTime <=", value, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("RetireTime in", values, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("RetireTime not in", values, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RetireTime between", value1, value2, "retireTime");
            return (Criteria) this;
        }

        public Criteria andRetireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RetireTime not between", value1, value2, "retireTime");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("Tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("Tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("Tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("Tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("Tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("Tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("Tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("Tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("Tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("Tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("Tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("Tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("Tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("Tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
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

        public Criteria andSpouseNameIsNull() {
            addCriterion("SpouseName is null");
            return (Criteria) this;
        }

        public Criteria andSpouseNameIsNotNull() {
            addCriterion("SpouseName is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseNameEqualTo(String value) {
            addCriterion("SpouseName =", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotEqualTo(String value) {
            addCriterion("SpouseName <>", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameGreaterThan(String value) {
            addCriterion("SpouseName >", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("SpouseName >=", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLessThan(String value) {
            addCriterion("SpouseName <", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLessThanOrEqualTo(String value) {
            addCriterion("SpouseName <=", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLike(String value) {
            addCriterion("SpouseName like", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotLike(String value) {
            addCriterion("SpouseName not like", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameIn(List<String> values) {
            addCriterion("SpouseName in", values, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotIn(List<String> values) {
            addCriterion("SpouseName not in", values, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameBetween(String value1, String value2) {
            addCriterion("SpouseName between", value1, value2, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotBetween(String value1, String value2) {
            addCriterion("SpouseName not between", value1, value2, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeIsNull() {
            addCriterion("SpouseCode is null");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeIsNotNull() {
            addCriterion("SpouseCode is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeEqualTo(String value) {
            addCriterion("SpouseCode =", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeNotEqualTo(String value) {
            addCriterion("SpouseCode <>", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeGreaterThan(String value) {
            addCriterion("SpouseCode >", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SpouseCode >=", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeLessThan(String value) {
            addCriterion("SpouseCode <", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeLessThanOrEqualTo(String value) {
            addCriterion("SpouseCode <=", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeLike(String value) {
            addCriterion("SpouseCode like", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeNotLike(String value) {
            addCriterion("SpouseCode not like", value, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeIn(List<String> values) {
            addCriterion("SpouseCode in", values, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeNotIn(List<String> values) {
            addCriterion("SpouseCode not in", values, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeBetween(String value1, String value2) {
            addCriterion("SpouseCode between", value1, value2, "spouseCode");
            return (Criteria) this;
        }

        public Criteria andSpouseCodeNotBetween(String value1, String value2) {
            addCriterion("SpouseCode not between", value1, value2, "spouseCode");
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

        public Criteria andSpouseDeptIsNull() {
            addCriterion("SpouseDept is null");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptIsNotNull() {
            addCriterion("SpouseDept is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptEqualTo(String value) {
            addCriterion("SpouseDept =", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptNotEqualTo(String value) {
            addCriterion("SpouseDept <>", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptGreaterThan(String value) {
            addCriterion("SpouseDept >", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptGreaterThanOrEqualTo(String value) {
            addCriterion("SpouseDept >=", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptLessThan(String value) {
            addCriterion("SpouseDept <", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptLessThanOrEqualTo(String value) {
            addCriterion("SpouseDept <=", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptLike(String value) {
            addCriterion("SpouseDept like", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptNotLike(String value) {
            addCriterion("SpouseDept not like", value, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptIn(List<String> values) {
            addCriterion("SpouseDept in", values, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptNotIn(List<String> values) {
            addCriterion("SpouseDept not in", values, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptBetween(String value1, String value2) {
            addCriterion("SpouseDept between", value1, value2, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseDeptNotBetween(String value1, String value2) {
            addCriterion("SpouseDept not between", value1, value2, "spouseDept");
            return (Criteria) this;
        }

        public Criteria andSpouseKindIsNull() {
            addCriterion("SpouseKind is null");
            return (Criteria) this;
        }

        public Criteria andSpouseKindIsNotNull() {
            addCriterion("SpouseKind is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseKindEqualTo(Integer value) {
            addCriterion("SpouseKind =", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindNotEqualTo(Integer value) {
            addCriterion("SpouseKind <>", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindGreaterThan(Integer value) {
            addCriterion("SpouseKind >", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpouseKind >=", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindLessThan(Integer value) {
            addCriterion("SpouseKind <", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindLessThanOrEqualTo(Integer value) {
            addCriterion("SpouseKind <=", value, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindIn(List<Integer> values) {
            addCriterion("SpouseKind in", values, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindNotIn(List<Integer> values) {
            addCriterion("SpouseKind not in", values, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindBetween(Integer value1, Integer value2) {
            addCriterion("SpouseKind between", value1, value2, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andSpouseKindNotBetween(Integer value1, Integer value2) {
            addCriterion("SpouseKind not between", value1, value2, "spouseKind");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageIsNull() {
            addCriterion("IsDeptManage is null");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageIsNotNull() {
            addCriterion("IsDeptManage is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageEqualTo(Boolean value) {
            addCriterion("IsDeptManage =", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageNotEqualTo(Boolean value) {
            addCriterion("IsDeptManage <>", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageGreaterThan(Boolean value) {
            addCriterion("IsDeptManage >", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDeptManage >=", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageLessThan(Boolean value) {
            addCriterion("IsDeptManage <", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDeptManage <=", value, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageIn(List<Boolean> values) {
            addCriterion("IsDeptManage in", values, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageNotIn(List<Boolean> values) {
            addCriterion("IsDeptManage not in", values, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDeptManage between", value1, value2, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andIsDeptManageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDeptManage not between", value1, value2, "isDeptManage");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNull() {
            addCriterion("StaffPassword is null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNotNull() {
            addCriterion("StaffPassword is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordEqualTo(String value) {
            addCriterion("StaffPassword =", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotEqualTo(String value) {
            addCriterion("StaffPassword <>", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThan(String value) {
            addCriterion("StaffPassword >", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("StaffPassword >=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThan(String value) {
            addCriterion("StaffPassword <", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThanOrEqualTo(String value) {
            addCriterion("StaffPassword <=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLike(String value) {
            addCriterion("StaffPassword like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotLike(String value) {
            addCriterion("StaffPassword not like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIn(List<String> values) {
            addCriterion("StaffPassword in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotIn(List<String> values) {
            addCriterion("StaffPassword not in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordBetween(String value1, String value2) {
            addCriterion("StaffPassword between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotBetween(String value1, String value2) {
            addCriterion("StaffPassword not between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andBuyAccountIsNull() {
            addCriterion("BuyAccount is null");
            return (Criteria) this;
        }

        public Criteria andBuyAccountIsNotNull() {
            addCriterion("BuyAccount is not null");
            return (Criteria) this;
        }

        public Criteria andBuyAccountEqualTo(Long value) {
            addCriterion("BuyAccount =", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountNotEqualTo(Long value) {
            addCriterion("BuyAccount <>", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountGreaterThan(Long value) {
            addCriterion("BuyAccount >", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountGreaterThanOrEqualTo(Long value) {
            addCriterion("BuyAccount >=", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountLessThan(Long value) {
            addCriterion("BuyAccount <", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountLessThanOrEqualTo(Long value) {
            addCriterion("BuyAccount <=", value, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountIn(List<Long> values) {
            addCriterion("BuyAccount in", values, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountNotIn(List<Long> values) {
            addCriterion("BuyAccount not in", values, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountBetween(Long value1, Long value2) {
            addCriterion("BuyAccount between", value1, value2, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andBuyAccountNotBetween(Long value1, Long value2) {
            addCriterion("BuyAccount not between", value1, value2, "buyAccount");
            return (Criteria) this;
        }

        public Criteria andCompensateIsNull() {
            addCriterion("Compensate is null");
            return (Criteria) this;
        }

        public Criteria andCompensateIsNotNull() {
            addCriterion("Compensate is not null");
            return (Criteria) this;
        }

        public Criteria andCompensateEqualTo(BigDecimal value) {
            addCriterion("Compensate =", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotEqualTo(BigDecimal value) {
            addCriterion("Compensate <>", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateGreaterThan(BigDecimal value) {
            addCriterion("Compensate >", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Compensate >=", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateLessThan(BigDecimal value) {
            addCriterion("Compensate <", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Compensate <=", value, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateIn(List<BigDecimal> values) {
            addCriterion("Compensate in", values, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotIn(List<BigDecimal> values) {
            addCriterion("Compensate not in", values, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Compensate between", value1, value2, "compensate");
            return (Criteria) this;
        }

        public Criteria andCompensateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Compensate not between", value1, value2, "compensate");
            return (Criteria) this;
        }

        public Criteria andFixFundIsNull() {
            addCriterion("FixFund is null");
            return (Criteria) this;
        }

        public Criteria andFixFundIsNotNull() {
            addCriterion("FixFund is not null");
            return (Criteria) this;
        }

        public Criteria andFixFundEqualTo(Long value) {
            addCriterion("FixFund =", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundNotEqualTo(Long value) {
            addCriterion("FixFund <>", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundGreaterThan(Long value) {
            addCriterion("FixFund >", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundGreaterThanOrEqualTo(Long value) {
            addCriterion("FixFund >=", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundLessThan(Long value) {
            addCriterion("FixFund <", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundLessThanOrEqualTo(Long value) {
            addCriterion("FixFund <=", value, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundIn(List<Long> values) {
            addCriterion("FixFund in", values, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundNotIn(List<Long> values) {
            addCriterion("FixFund not in", values, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundBetween(Long value1, Long value2) {
            addCriterion("FixFund between", value1, value2, "fixFund");
            return (Criteria) this;
        }

        public Criteria andFixFundNotBetween(Long value1, Long value2) {
            addCriterion("FixFund not between", value1, value2, "fixFund");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeIsNull() {
            addCriterion("SecondJoinTime is null");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeIsNotNull() {
            addCriterion("SecondJoinTime is not null");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeEqualTo(Date value) {
            addCriterionForJDBCDate("SecondJoinTime =", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("SecondJoinTime <>", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("SecondJoinTime >", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SecondJoinTime >=", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeLessThan(Date value) {
            addCriterionForJDBCDate("SecondJoinTime <", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SecondJoinTime <=", value, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeIn(List<Date> values) {
            addCriterionForJDBCDate("SecondJoinTime in", values, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("SecondJoinTime not in", values, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SecondJoinTime between", value1, value2, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondJoinTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SecondJoinTime not between", value1, value2, "secondJoinTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeIsNull() {
            addCriterion("SecondRetireTime is null");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeIsNotNull() {
            addCriterion("SecondRetireTime is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeEqualTo(Date value) {
            addCriterionForJDBCDate("SecondRetireTime =", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("SecondRetireTime <>", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("SecondRetireTime >", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SecondRetireTime >=", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeLessThan(Date value) {
            addCriterionForJDBCDate("SecondRetireTime <", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SecondRetireTime <=", value, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("SecondRetireTime in", values, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("SecondRetireTime not in", values, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SecondRetireTime between", value1, value2, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andSecondRetireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SecondRetireTime not between", value1, value2, "secondRetireTime");
            return (Criteria) this;
        }

        public Criteria andStaffDualIsNull() {
            addCriterion("StaffDual is null");
            return (Criteria) this;
        }

        public Criteria andStaffDualIsNotNull() {
            addCriterion("StaffDual is not null");
            return (Criteria) this;
        }

        public Criteria andStaffDualEqualTo(String value) {
            addCriterion("StaffDual =", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotEqualTo(String value) {
            addCriterion("StaffDual <>", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualGreaterThan(String value) {
            addCriterion("StaffDual >", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualGreaterThanOrEqualTo(String value) {
            addCriterion("StaffDual >=", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLessThan(String value) {
            addCriterion("StaffDual <", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLessThanOrEqualTo(String value) {
            addCriterion("StaffDual <=", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualLike(String value) {
            addCriterion("StaffDual like", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotLike(String value) {
            addCriterion("StaffDual not like", value, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualIn(List<String> values) {
            addCriterion("StaffDual in", values, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotIn(List<String> values) {
            addCriterion("StaffDual not in", values, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualBetween(String value1, String value2) {
            addCriterion("StaffDual between", value1, value2, "staffDual");
            return (Criteria) this;
        }

        public Criteria andStaffDualNotBetween(String value1, String value2) {
            addCriterion("StaffDual not between", value1, value2, "staffDual");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("Relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("Relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("Relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("Relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("Relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("Relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("Relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("Relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("Relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("Relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("Relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("Relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("Relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("Relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("DiscountRate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("DiscountRate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(Double value) {
            addCriterion("DiscountRate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(Double value) {
            addCriterion("DiscountRate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(Double value) {
            addCriterion("DiscountRate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(Double value) {
            addCriterion("DiscountRate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(Double value) {
            addCriterion("DiscountRate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(Double value) {
            addCriterion("DiscountRate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<Double> values) {
            addCriterion("DiscountRate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<Double> values) {
            addCriterion("DiscountRate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(Double value1, Double value2) {
            addCriterion("DiscountRate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(Double value1, Double value2) {
            addCriterion("DiscountRate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeIsNull() {
            addCriterion("FamilyCode is null");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeIsNotNull() {
            addCriterion("FamilyCode is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeEqualTo(Integer value) {
            addCriterion("FamilyCode =", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotEqualTo(Integer value) {
            addCriterion("FamilyCode <>", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeGreaterThan(Integer value) {
            addCriterion("FamilyCode >", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FamilyCode >=", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeLessThan(Integer value) {
            addCriterion("FamilyCode <", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeLessThanOrEqualTo(Integer value) {
            addCriterion("FamilyCode <=", value, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeIn(List<Integer> values) {
            addCriterion("FamilyCode in", values, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotIn(List<Integer> values) {
            addCriterion("FamilyCode not in", values, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeBetween(Integer value1, Integer value2) {
            addCriterion("FamilyCode between", value1, value2, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFamilyCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("FamilyCode not between", value1, value2, "familyCode");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeIsNull() {
            addCriterion("FirstJobTime is null");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeIsNotNull() {
            addCriterion("FirstJobTime is not null");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FirstJobTime =", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FirstJobTime <>", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FirstJobTime >", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FirstJobTime >=", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeLessThan(Date value) {
            addCriterionForJDBCDate("FirstJobTime <", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FirstJobTime <=", value, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FirstJobTime in", values, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FirstJobTime not in", values, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FirstJobTime between", value1, value2, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andFirstJobTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FirstJobTime not between", value1, value2, "firstJobTime");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("UserName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("UserName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("UserName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("UserName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("UserName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("UserName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseIsNull() {
            addCriterion("IsOwnPriHouse is null");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseIsNotNull() {
            addCriterion("IsOwnPriHouse is not null");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseEqualTo(Boolean value) {
            addCriterion("IsOwnPriHouse =", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseNotEqualTo(Boolean value) {
            addCriterion("IsOwnPriHouse <>", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseGreaterThan(Boolean value) {
            addCriterion("IsOwnPriHouse >", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsOwnPriHouse >=", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseLessThan(Boolean value) {
            addCriterion("IsOwnPriHouse <", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseLessThanOrEqualTo(Boolean value) {
            addCriterion("IsOwnPriHouse <=", value, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseIn(List<Boolean> values) {
            addCriterion("IsOwnPriHouse in", values, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseNotIn(List<Boolean> values) {
            addCriterion("IsOwnPriHouse not in", values, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOwnPriHouse between", value1, value2, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andIsOwnPriHouseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsOwnPriHouse not between", value1, value2, "isOwnPriHouse");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("RoleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("RoleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("RoleId =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("RoleId <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("RoleId >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RoleId >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("RoleId <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("RoleId <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("RoleId in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("RoleId not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("RoleId between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RoleId not between", value1, value2, "roleId");
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