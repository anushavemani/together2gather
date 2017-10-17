package com.us.g2g.model;

import java.io.Serializable;
import java.util.Date;

public class TimelineData  implements Serializable{

	private Date actionDateTime;
	private String action;
	private String description;
	
	public Date getActionDateTime() {
		return actionDateTime;
	}
	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
