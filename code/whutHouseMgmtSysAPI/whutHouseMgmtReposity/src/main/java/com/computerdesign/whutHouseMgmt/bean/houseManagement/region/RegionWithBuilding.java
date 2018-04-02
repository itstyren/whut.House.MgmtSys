package com.computerdesign.whutHouseMgmt.bean.houseManagement.region;

import java.util.List;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.Building;

public class RegionWithBuilding {
    private Integer id;

    private String name;

    private String description;

    private Integer campusId;

    private String campusName;
    
    private List<Building> buildingList;
    
    public List<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}

	public RegionWithBuilding(ViewRegion viewRegion, List<Building> buildingList) {
		super();
		this.id = viewRegion.getId();
		this.name = viewRegion.getName();
		this.description = viewRegion.getDescription();
		this.campusId = viewRegion.getCampusId();
		this.campusName = viewRegion.getCampusName();
		this.buildingList = buildingList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Integer getCampusId() {
		return campusId;
	}

	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
    
    
}