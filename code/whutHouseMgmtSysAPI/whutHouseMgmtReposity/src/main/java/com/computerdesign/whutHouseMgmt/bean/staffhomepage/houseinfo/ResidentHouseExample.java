package com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResidentHouseExample() {
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

        public Criteria andHouseStructIdIsNull() {
            addCriterion("HouseStructId is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdIsNotNull() {
            addCriterion("HouseStructId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdEqualTo(Integer value) {
            addCriterion("HouseStructId =", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotEqualTo(Integer value) {
            addCriterion("HouseStructId <>", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdGreaterThan(Integer value) {
            addCriterion("HouseStructId >", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseStructId >=", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdLessThan(Integer value) {
            addCriterion("HouseStructId <", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseStructId <=", value, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdIn(List<Integer> values) {
            addCriterion("HouseStructId in", values, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotIn(List<Integer> values) {
            addCriterion("HouseStructId not in", values, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseStructId between", value1, value2, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseStructId not between", value1, value2, "houseStructId");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIsNull() {
            addCriterion("HouseStructName is null");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIsNotNull() {
            addCriterion("HouseStructName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameEqualTo(String value) {
            addCriterion("HouseStructName =", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotEqualTo(String value) {
            addCriterion("HouseStructName <>", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameGreaterThan(String value) {
            addCriterion("HouseStructName >", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseStructName >=", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLessThan(String value) {
            addCriterion("HouseStructName <", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLessThanOrEqualTo(String value) {
            addCriterion("HouseStructName <=", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameLike(String value) {
            addCriterion("HouseStructName like", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotLike(String value) {
            addCriterion("HouseStructName not like", value, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameIn(List<String> values) {
            addCriterion("HouseStructName in", values, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotIn(List<String> values) {
            addCriterion("HouseStructName not in", values, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameBetween(String value1, String value2) {
            addCriterion("HouseStructName between", value1, value2, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseStructNameNotBetween(String value1, String value2) {
            addCriterion("HouseStructName not between", value1, value2, "houseStructName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdIsNull() {
            addCriterion("HouseLayoutId is null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdIsNotNull() {
            addCriterion("HouseLayoutId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdEqualTo(Integer value) {
            addCriterion("HouseLayoutId =", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdNotEqualTo(Integer value) {
            addCriterion("HouseLayoutId <>", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdGreaterThan(Integer value) {
            addCriterion("HouseLayoutId >", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseLayoutId >=", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdLessThan(Integer value) {
            addCriterion("HouseLayoutId <", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseLayoutId <=", value, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdIn(List<Integer> values) {
            addCriterion("HouseLayoutId in", values, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdNotIn(List<Integer> values) {
            addCriterion("HouseLayoutId not in", values, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseLayoutId between", value1, value2, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseLayoutId not between", value1, value2, "houseLayoutId");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIsNull() {
            addCriterion("HouseLayoutName is null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIsNotNull() {
            addCriterion("HouseLayoutName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameEqualTo(String value) {
            addCriterion("HouseLayoutName =", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotEqualTo(String value) {
            addCriterion("HouseLayoutName <>", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameGreaterThan(String value) {
            addCriterion("HouseLayoutName >", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseLayoutName >=", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLessThan(String value) {
            addCriterion("HouseLayoutName <", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLessThanOrEqualTo(String value) {
            addCriterion("HouseLayoutName <=", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameLike(String value) {
            addCriterion("HouseLayoutName like", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotLike(String value) {
            addCriterion("HouseLayoutName not like", value, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameIn(List<String> values) {
            addCriterion("HouseLayoutName in", values, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotIn(List<String> values) {
            addCriterion("HouseLayoutName not in", values, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameBetween(String value1, String value2) {
            addCriterion("HouseLayoutName between", value1, value2, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseLayoutNameNotBetween(String value1, String value2) {
            addCriterion("HouseLayoutName not between", value1, value2, "houseLayoutName");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdIsNull() {
            addCriterion("HouseRelId is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdIsNotNull() {
            addCriterion("HouseRelId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdEqualTo(Integer value) {
            addCriterion("HouseRelId =", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdNotEqualTo(Integer value) {
            addCriterion("HouseRelId <>", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdGreaterThan(Integer value) {
            addCriterion("HouseRelId >", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseRelId >=", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdLessThan(Integer value) {
            addCriterion("HouseRelId <", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseRelId <=", value, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdIn(List<Integer> values) {
            addCriterion("HouseRelId in", values, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdNotIn(List<Integer> values) {
            addCriterion("HouseRelId not in", values, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseRelId between", value1, value2, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseRelId not between", value1, value2, "houseRelId");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIsNull() {
            addCriterion("HouseRelName is null");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIsNotNull() {
            addCriterion("HouseRelName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameEqualTo(String value) {
            addCriterion("HouseRelName =", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotEqualTo(String value) {
            addCriterion("HouseRelName <>", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameGreaterThan(String value) {
            addCriterion("HouseRelName >", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseRelName >=", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLessThan(String value) {
            addCriterion("HouseRelName <", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLessThanOrEqualTo(String value) {
            addCriterion("HouseRelName <=", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameLike(String value) {
            addCriterion("HouseRelName like", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotLike(String value) {
            addCriterion("HouseRelName not like", value, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameIn(List<String> values) {
            addCriterion("HouseRelName in", values, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotIn(List<String> values) {
            addCriterion("HouseRelName not in", values, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameBetween(String value1, String value2) {
            addCriterion("HouseRelName between", value1, value2, "houseRelName");
            return (Criteria) this;
        }

        public Criteria andHouseRelNameNotBetween(String value1, String value2) {
            addCriterion("HouseRelName not between", value1, value2, "houseRelName");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("PayType is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PayType is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("PayType =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("PayType <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("PayType >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PayType >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("PayType <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PayType <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("PayType in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("PayType not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PayType between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PayType not between", value1, value2, "payType");
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

        public Criteria andHouseTypeIdIsNull() {
            addCriterion("HouseTypeId is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdIsNotNull() {
            addCriterion("HouseTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdEqualTo(Integer value) {
            addCriterion("HouseTypeId =", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotEqualTo(Integer value) {
            addCriterion("HouseTypeId <>", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdGreaterThan(Integer value) {
            addCriterion("HouseTypeId >", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HouseTypeId >=", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdLessThan(Integer value) {
            addCriterion("HouseTypeId <", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("HouseTypeId <=", value, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdIn(List<Integer> values) {
            addCriterion("HouseTypeId in", values, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotIn(List<Integer> values) {
            addCriterion("HouseTypeId not in", values, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("HouseTypeId between", value1, value2, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HouseTypeId not between", value1, value2, "houseTypeId");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIsNull() {
            addCriterion("HouseTypeName is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIsNotNull() {
            addCriterion("HouseTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameEqualTo(String value) {
            addCriterion("HouseTypeName =", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotEqualTo(String value) {
            addCriterion("HouseTypeName <>", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameGreaterThan(String value) {
            addCriterion("HouseTypeName >", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("HouseTypeName >=", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLessThan(String value) {
            addCriterion("HouseTypeName <", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLessThanOrEqualTo(String value) {
            addCriterion("HouseTypeName <=", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameLike(String value) {
            addCriterion("HouseTypeName like", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotLike(String value) {
            addCriterion("HouseTypeName not like", value, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameIn(List<String> values) {
            addCriterion("HouseTypeName in", values, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotIn(List<String> values) {
            addCriterion("HouseTypeName not in", values, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameBetween(String value1, String value2) {
            addCriterion("HouseTypeName between", value1, value2, "houseTypeName");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNameNotBetween(String value1, String value2) {
            addCriterion("HouseTypeName not between", value1, value2, "houseTypeName");
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