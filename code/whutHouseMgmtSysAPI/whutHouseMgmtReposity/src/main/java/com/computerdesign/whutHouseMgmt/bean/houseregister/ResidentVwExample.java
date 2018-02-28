package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResidentVwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResidentVwExample() {
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

        public Criteria andHouseRelIsNull() {
            addCriterion("HouseRel is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelIsNotNull() {
            addCriterion("HouseRel is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelEqualTo(String value) {
            addCriterion("HouseRel =", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotEqualTo(String value) {
            addCriterion("HouseRel <>", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelGreaterThan(String value) {
            addCriterion("HouseRel >", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelGreaterThanOrEqualTo(String value) {
            addCriterion("HouseRel >=", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelLessThan(String value) {
            addCriterion("HouseRel <", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelLessThanOrEqualTo(String value) {
            addCriterion("HouseRel <=", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelLike(String value) {
            addCriterion("HouseRel like", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotLike(String value) {
            addCriterion("HouseRel not like", value, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelIn(List<String> values) {
            addCriterion("HouseRel in", values, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotIn(List<String> values) {
            addCriterion("HouseRel not in", values, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelBetween(String value1, String value2) {
            addCriterion("HouseRel between", value1, value2, "houseRel");
            return (Criteria) this;
        }

        public Criteria andHouseRelNotBetween(String value1, String value2) {
            addCriterion("HouseRel not between", value1, value2, "houseRel");
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
            addCriterionForJDBCDate("BookTime =", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime <>", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BookTime >", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime >=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThan(Date value) {
            addCriterionForJDBCDate("BookTime <", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BookTime <=", value, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeIn(List<Date> values) {
            addCriterionForJDBCDate("BookTime in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BookTime not in", values, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookTime between", value1, value2, "bookTime");
            return (Criteria) this;
        }

        public Criteria andBookTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BookTime not between", value1, value2, "bookTime");
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

        public Criteria andHouseTypeIsNull() {
            addCriterion("HouseType is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("HouseType is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(Integer value) {
            addCriterion("HouseType =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(Integer value) {
            addCriterion("HouseType <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(Integer value) {
            addCriterion("HouseType >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseType >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(Integer value) {
            addCriterion("HouseType <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("HouseType <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<Integer> values) {
            addCriterion("HouseType in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<Integer> values) {
            addCriterion("HouseType not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(Integer value1, Integer value2) {
            addCriterion("HouseType between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseType not between", value1, value2, "houseType");
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
            addCriterionForJDBCDate("ExpireTime =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ExpireTime >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterionForJDBCDate("ExpireTime <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpireTime <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ExpireTime in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ExpireTime not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpireTime between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpireTime not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeIsNull() {
            addCriterion("LastRentType is null");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeIsNotNull() {
            addCriterion("LastRentType is not null");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeEqualTo(String value) {
            addCriterion("LastRentType =", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotEqualTo(String value) {
            addCriterion("LastRentType <>", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeGreaterThan(String value) {
            addCriterion("LastRentType >", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LastRentType >=", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLessThan(String value) {
            addCriterion("LastRentType <", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLessThanOrEqualTo(String value) {
            addCriterion("LastRentType <=", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeLike(String value) {
            addCriterion("LastRentType like", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotLike(String value) {
            addCriterion("LastRentType not like", value, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeIn(List<String> values) {
            addCriterion("LastRentType in", values, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotIn(List<String> values) {
            addCriterion("LastRentType not in", values, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeBetween(String value1, String value2) {
            addCriterion("LastRentType between", value1, value2, "lastRentType");
            return (Criteria) this;
        }

        public Criteria andLastRentTypeNotBetween(String value1, String value2) {
            addCriterion("LastRentType not between", value1, value2, "lastRentType");
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