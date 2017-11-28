package com.computerdesign.whutHouseMgmt.bean.region;

import java.util.List;

import com.computerdesign.whutHouseMgmt.bean.building.Building;

public class RegionWithBuilding {
    private Integer id;

    private String name;

    private String description;

    private List<Building> buildingList;
    
    public List<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}

	public RegionWithBuilding(Region region, List<Building> buildingList) {
		super();
		this.id = region.getId();
		this.name = region.getName();
		this.description = region.getDescription();
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
}