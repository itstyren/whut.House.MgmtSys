package com.computerdesign.whutHouseMgmt.bean.fix;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FixGetAccept {

	private Integer id;

    private String fixContentId;

    private String fixContentName;

    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyTime;
    
    private String staffName;

    private String titleName;

    private String postName;

    private String deptName;
    
    private String phone;
    
    private String staffAddress;
}
