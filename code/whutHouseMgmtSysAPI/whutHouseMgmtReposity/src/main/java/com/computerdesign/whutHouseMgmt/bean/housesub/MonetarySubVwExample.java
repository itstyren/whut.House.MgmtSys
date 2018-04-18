package com.computerdesign.whutHouseMgmt.bean.housesub;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MonetarySubVwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonetarySubVwExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("Year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("Year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andAnnualSalIsNull() {
            addCriterion("AnnualSal is null");
            return (Criteria) this;
        }

        public Criteria andAnnualSalIsNotNull() {
            addCriterion("AnnualSal is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualSalEqualTo(Long value) {
            addCriterion("AnnualSal =", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalNotEqualTo(Long value) {
            addCriterion("AnnualSal <>", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalGreaterThan(Long value) {
            addCriterion("AnnualSal >", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalGreaterThanOrEqualTo(Long value) {
            addCriterion("AnnualSal >=", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalLessThan(Long value) {
            addCriterion("AnnualSal <", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalLessThanOrEqualTo(Long value) {
            addCriterion("AnnualSal <=", value, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalIn(List<Long> values) {
            addCriterion("AnnualSal in", values, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalNotIn(List<Long> values) {
            addCriterion("AnnualSal not in", values, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalBetween(Long value1, Long value2) {
            addCriterion("AnnualSal between", value1, value2, "annualSal");
            return (Criteria) this;
        }

        public Criteria andAnnualSalNotBetween(Long value1, Long value2) {
            addCriterion("AnnualSal not between", value1, value2, "annualSal");
            return (Criteria) this;
        }

        public Criteria andSubsidiesIsNull() {
            addCriterion("Subsidies is null");
            return (Criteria) this;
        }

        public Criteria andSubsidiesIsNotNull() {
            addCriterion("Subsidies is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidiesEqualTo(Long value) {
            addCriterion("Subsidies =", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesNotEqualTo(Long value) {
            addCriterion("Subsidies <>", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesGreaterThan(Long value) {
            addCriterion("Subsidies >", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesGreaterThanOrEqualTo(Long value) {
            addCriterion("Subsidies >=", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesLessThan(Long value) {
            addCriterion("Subsidies <", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesLessThanOrEqualTo(Long value) {
            addCriterion("Subsidies <=", value, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesIn(List<Long> values) {
            addCriterion("Subsidies in", values, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesNotIn(List<Long> values) {
            addCriterion("Subsidies not in", values, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesBetween(Long value1, Long value2) {
            addCriterion("Subsidies between", value1, value2, "subsidies");
            return (Criteria) this;
        }

        public Criteria andSubsidiesNotBetween(Long value1, Long value2) {
            addCriterion("Subsidies not between", value1, value2, "subsidies");
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

        public Criteria andDeptIdIsNull() {
            addCriterion("DeptId is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DeptId is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DeptId =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DeptId <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DeptId >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DeptId >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DeptId <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DeptId <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DeptId in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DeptId not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DeptId between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DeptId not between", value1, value2, "deptId");
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

        public Criteria andTitleHouseAreaIsNull() {
            addCriterion("TitleHouseArea is null");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaIsNotNull() {
            addCriterion("TitleHouseArea is not null");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaEqualTo(Float value) {
            addCriterion("TitleHouseArea =", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaNotEqualTo(Float value) {
            addCriterion("TitleHouseArea <>", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaGreaterThan(Float value) {
            addCriterion("TitleHouseArea >", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("TitleHouseArea >=", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaLessThan(Float value) {
            addCriterion("TitleHouseArea <", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaLessThanOrEqualTo(Float value) {
            addCriterion("TitleHouseArea <=", value, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaIn(List<Float> values) {
            addCriterion("TitleHouseArea in", values, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaNotIn(List<Float> values) {
            addCriterion("TitleHouseArea not in", values, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaBetween(Float value1, Float value2) {
            addCriterion("TitleHouseArea between", value1, value2, "titleHouseArea");
            return (Criteria) this;
        }

        public Criteria andTitleHouseAreaNotBetween(Float value1, Float value2) {
            addCriterion("TitleHouseArea not between", value1, value2, "titleHouseArea");
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

        public Criteria andPostHouseAreaIsNull() {
            addCriterion("PostHouseArea is null");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaIsNotNull() {
            addCriterion("PostHouseArea is not null");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaEqualTo(Float value) {
            addCriterion("PostHouseArea =", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaNotEqualTo(Float value) {
            addCriterion("PostHouseArea <>", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaGreaterThan(Float value) {
            addCriterion("PostHouseArea >", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("PostHouseArea >=", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaLessThan(Float value) {
            addCriterion("PostHouseArea <", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaLessThanOrEqualTo(Float value) {
            addCriterion("PostHouseArea <=", value, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaIn(List<Float> values) {
            addCriterion("PostHouseArea in", values, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaNotIn(List<Float> values) {
            addCriterion("PostHouseArea not in", values, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaBetween(Float value1, Float value2) {
            addCriterion("PostHouseArea between", value1, value2, "postHouseArea");
            return (Criteria) this;
        }

        public Criteria andPostHouseAreaNotBetween(Float value1, Float value2) {
            addCriterion("PostHouseArea not between", value1, value2, "postHouseArea");
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