package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HouseStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseStaffExample() {
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

        public Criteria andLayoutNameIsNull() {
            addCriterion("LayoutName is null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIsNotNull() {
            addCriterion("LayoutName is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameEqualTo(String value) {
            addCriterion("LayoutName =", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotEqualTo(String value) {
            addCriterion("LayoutName <>", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThan(String value) {
            addCriterion("LayoutName >", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("LayoutName >=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThan(String value) {
            addCriterion("LayoutName <", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThanOrEqualTo(String value) {
            addCriterion("LayoutName <=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLike(String value) {
            addCriterion("LayoutName like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotLike(String value) {
            addCriterion("LayoutName not like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIn(List<String> values) {
            addCriterion("LayoutName in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotIn(List<String> values) {
            addCriterion("LayoutName not in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameBetween(String value1, String value2) {
            addCriterion("LayoutName between", value1, value2, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotBetween(String value1, String value2) {
            addCriterion("LayoutName not between", value1, value2, "layoutName");
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

        public Criteria andStructNameIsNull() {
            addCriterion("StructName is null");
            return (Criteria) this;
        }

        public Criteria andStructNameIsNotNull() {
            addCriterion("StructName is not null");
            return (Criteria) this;
        }

        public Criteria andStructNameEqualTo(String value) {
            addCriterion("StructName =", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotEqualTo(String value) {
            addCriterion("StructName <>", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameGreaterThan(String value) {
            addCriterion("StructName >", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameGreaterThanOrEqualTo(String value) {
            addCriterion("StructName >=", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLessThan(String value) {
            addCriterion("StructName <", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLessThanOrEqualTo(String value) {
            addCriterion("StructName <=", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameLike(String value) {
            addCriterion("StructName like", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotLike(String value) {
            addCriterion("StructName not like", value, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameIn(List<String> values) {
            addCriterion("StructName in", values, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotIn(List<String> values) {
            addCriterion("StructName not in", values, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameBetween(String value1, String value2) {
            addCriterion("StructName between", value1, value2, "structName");
            return (Criteria) this;
        }

        public Criteria andStructNameNotBetween(String value1, String value2) {
            addCriterion("StructName not between", value1, value2, "structName");
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

        public Criteria andRegionIdIsNull() {
            addCriterion("RegionId is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("RegionId is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Integer value) {
            addCriterion("RegionId =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Integer value) {
            addCriterion("RegionId <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Integer value) {
            addCriterion("RegionId >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RegionId >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Integer value) {
            addCriterion("RegionId <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("RegionId <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Integer> values) {
            addCriterion("RegionId in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Integer> values) {
            addCriterion("RegionId not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("RegionId between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RegionId not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("RegionName is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("RegionName is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("RegionName =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("RegionName <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("RegionName >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("RegionName >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("RegionName <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("RegionName <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("RegionName like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("RegionName not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("RegionName in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("RegionName not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("RegionName between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("RegionName not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andCampusIdIsNull() {
            addCriterion("CampusId is null");
            return (Criteria) this;
        }

        public Criteria andCampusIdIsNotNull() {
            addCriterion("CampusId is not null");
            return (Criteria) this;
        }

        public Criteria andCampusIdEqualTo(Integer value) {
            addCriterion("CampusId =", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotEqualTo(Integer value) {
            addCriterion("CampusId <>", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThan(Integer value) {
            addCriterion("CampusId >", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CampusId >=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThan(Integer value) {
            addCriterion("CampusId <", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThanOrEqualTo(Integer value) {
            addCriterion("CampusId <=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdIn(List<Integer> values) {
            addCriterion("CampusId in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotIn(List<Integer> values) {
            addCriterion("CampusId not in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdBetween(Integer value1, Integer value2) {
            addCriterion("CampusId between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CampusId not between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusNameIsNull() {
            addCriterion("CampusName is null");
            return (Criteria) this;
        }

        public Criteria andCampusNameIsNotNull() {
            addCriterion("CampusName is not null");
            return (Criteria) this;
        }

        public Criteria andCampusNameEqualTo(String value) {
            addCriterion("CampusName =", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotEqualTo(String value) {
            addCriterion("CampusName <>", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameGreaterThan(String value) {
            addCriterion("CampusName >", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameGreaterThanOrEqualTo(String value) {
            addCriterion("CampusName >=", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLessThan(String value) {
            addCriterion("CampusName <", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLessThanOrEqualTo(String value) {
            addCriterion("CampusName <=", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameLike(String value) {
            addCriterion("CampusName like", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotLike(String value) {
            addCriterion("CampusName not like", value, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameIn(List<String> values) {
            addCriterion("CampusName in", values, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotIn(List<String> values) {
            addCriterion("CampusName not in", values, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameBetween(String value1, String value2) {
            addCriterion("CampusName between", value1, value2, "campusName");
            return (Criteria) this;
        }

        public Criteria andCampusNameNotBetween(String value1, String value2) {
            addCriterion("CampusName not between", value1, value2, "campusName");
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

        public Criteria andResidentIdIsNull() {
            addCriterion("ResidentId is null");
            return (Criteria) this;
        }

        public Criteria andResidentIdIsNotNull() {
            addCriterion("ResidentId is not null");
            return (Criteria) this;
        }

        public Criteria andResidentIdEqualTo(Integer value) {
            addCriterion("ResidentId =", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotEqualTo(Integer value) {
            addCriterion("ResidentId <>", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdGreaterThan(Integer value) {
            addCriterion("ResidentId >", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ResidentId >=", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdLessThan(Integer value) {
            addCriterion("ResidentId <", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdLessThanOrEqualTo(Integer value) {
            addCriterion("ResidentId <=", value, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdIn(List<Integer> values) {
            addCriterion("ResidentId in", values, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotIn(List<Integer> values) {
            addCriterion("ResidentId not in", values, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdBetween(Integer value1, Integer value2) {
            addCriterion("ResidentId between", value1, value2, "residentId");
            return (Criteria) this;
        }

        public Criteria andResidentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ResidentId not between", value1, value2, "residentId");
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

        public Criteria andBookTimeIsNull() {
            addCriterion("BookTime is null");
            return (Criteria) this;
        }

        public Criteria andBookTimeIsNotNull() {
            addCriterion("BookTime is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimeEqualTo(Date value) {
            addCriterion("BookTime =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterion("BookTime <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterion("BookTime >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BookTime >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterion("BookTime <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterion("BookTime <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterion("BookTime in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterion("BookTime not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterion("BookTime between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterion("BookTime not between", value1, value2, "bookTime");
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

        public Criteria andStaffSexIsNull() {
            addCriterion("StaffSex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("StaffSex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("StaffSex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("StaffSex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("StaffSex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("StaffSex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("StaffSex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("StaffSex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("StaffSex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("StaffSex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("StaffSex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("StaffSex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("StaffSex not between", value1, value2, "staffSex");
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

        public Criteria andStaffSpouseNameIsNull() {
            addCriterion("StaffSpouseName is null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameIsNotNull() {
            addCriterion("StaffSpouseName is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameEqualTo(String value) {
            addCriterion("StaffSpouseName =", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotEqualTo(String value) {
            addCriterion("StaffSpouseName <>", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameGreaterThan(String value) {
            addCriterion("StaffSpouseName >", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("StaffSpouseName >=", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLessThan(String value) {
            addCriterion("StaffSpouseName <", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLessThanOrEqualTo(String value) {
            addCriterion("StaffSpouseName <=", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameLike(String value) {
            addCriterion("StaffSpouseName like", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotLike(String value) {
            addCriterion("StaffSpouseName not like", value, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameIn(List<String> values) {
            addCriterion("StaffSpouseName in", values, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotIn(List<String> values) {
            addCriterion("StaffSpouseName not in", values, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameBetween(String value1, String value2) {
            addCriterion("StaffSpouseName between", value1, value2, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffSpouseNameNotBetween(String value1, String value2) {
            addCriterion("StaffSpouseName not between", value1, value2, "staffSpouseName");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNull() {
            addCriterion("StaffType is null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIsNotNull() {
            addCriterion("StaffType is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTypeEqualTo(Integer value) {
            addCriterion("StaffType =", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotEqualTo(Integer value) {
            addCriterion("StaffType <>", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThan(Integer value) {
            addCriterion("StaffType >", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("StaffType >=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThan(Integer value) {
            addCriterion("StaffType <", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeLessThanOrEqualTo(Integer value) {
            addCriterion("StaffType <=", value, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeIn(List<Integer> values) {
            addCriterion("StaffType in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotIn(List<Integer> values) {
            addCriterion("StaffType not in", values, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeBetween(Integer value1, Integer value2) {
            addCriterion("StaffType between", value1, value2, "staffType");
            return (Criteria) this;
        }

        public Criteria andStaffTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("StaffType not between", value1, value2, "staffType");
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

        public Criteria andExpireTimeIsNull() {
            addCriterion("ExpireTime is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("ExpireTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("ExpireTime =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("ExpireTime <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("ExpireTime >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ExpireTime >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("ExpireTime <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("ExpireTime <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("ExpireTime in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("ExpireTime not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("ExpireTime between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("ExpireTime not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIsNull() {
            addCriterion("LastRentTime is null");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIsNotNull() {
            addCriterion("LastRentTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeEqualTo(Date value) {
            addCriterion("LastRentTime =", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotEqualTo(Date value) {
            addCriterion("LastRentTime <>", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeGreaterThan(Date value) {
            addCriterion("LastRentTime >", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastRentTime >=", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeLessThan(Date value) {
            addCriterion("LastRentTime <", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeLessThanOrEqualTo(Date value) {
            addCriterion("LastRentTime <=", value, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeIn(List<Date> values) {
            addCriterion("LastRentTime in", values, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotIn(List<Date> values) {
            addCriterion("LastRentTime not in", values, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeBetween(Date value1, Date value2) {
            addCriterion("LastRentTime between", value1, value2, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTimeNotBetween(Date value1, Date value2) {
            addCriterion("LastRentTime not between", value1, value2, "lastRentTime");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNull() {
            addCriterion("RentType is null");
            return (Criteria) this;
        }

        public Criteria andRentTypeIsNotNull() {
            addCriterion("RentType is not null");
            return (Criteria) this;
        }

        public Criteria andRentTypeEqualTo(String value) {
            addCriterion("RentType =", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotEqualTo(String value) {
            addCriterion("RentType <>", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThan(String value) {
            addCriterion("RentType >", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RentType >=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThan(String value) {
            addCriterion("RentType <", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLessThanOrEqualTo(String value) {
            addCriterion("RentType <=", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeLike(String value) {
            addCriterion("RentType like", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotLike(String value) {
            addCriterion("RentType not like", value, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeIn(List<String> values) {
            addCriterion("RentType in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotIn(List<String> values) {
            addCriterion("RentType not in", values, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeBetween(String value1, String value2) {
            addCriterion("RentType between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andRentTypeNotBetween(String value1, String value2) {
            addCriterion("RentType not between", value1, value2, "rentType");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IsDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IsDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("IsDelete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("IsDelete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("IsDelete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDelete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("IsDelete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDelete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("IsDelete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("IsDelete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDelete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDelete not between", value1, value2, "isDelete");
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