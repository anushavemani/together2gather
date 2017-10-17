package com.us.g2g.hbm;
// Generated Aug 3, 2017 12:41:26 AM by Hibernate Tools 5.2.3.Final

import java.util.Calendar;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import com.google.gson.annotations.Expose;

/**
 * Photo generated by hbm2java
 */
public class Photo implements java.io.Serializable {

	@Expose
	private Integer id;
	private Event event;
	private User userByUserId;
	private User userByApprovedBy;
	@Expose
	private String source;
	@Expose
	private String thumbSource;
	private transient Date dateTime;
	@Expose
	private Date approvedOn;

	public Photo() {
		dateTime = new Date();
	}

	public Photo(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Photo(Event event, User userByUserId, User userByApprovedBy, String source, String thumbSource,
			Date dateTime, Date approvedOn) {
		this.event = event;
		this.userByUserId = userByUserId;
		this.userByApprovedBy = userByApprovedBy;
		this.source = source;
		this.thumbSource = thumbSource;
		this.dateTime = dateTime;
		this.approvedOn = approvedOn;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	public User getUserByApprovedBy() {
		return this.userByApprovedBy;
	}

	public void setUserByApprovedBy(User userByApprovedBy) {
		this.userByApprovedBy = userByApprovedBy;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getThumbSource() {
		return this.thumbSource;
	}

	public void setThumbSource(String thumbSource) {
		this.thumbSource = thumbSource;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

}
