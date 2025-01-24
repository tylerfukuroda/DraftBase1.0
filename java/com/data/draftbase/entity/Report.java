package com.data.draftbase.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reports")
public class Report implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reportId")
	private long id;
	
	@Column
	private Double grade;
	
	@Column
	private LocalDateTime dateCreated;
	
	@Column
	private String summary;
	
	@Column
	private Long userId;
	
	@Column
	private Long playerId;
	
	public Report(Long playerId, Long userId, String summary, Double grade, LocalDateTime dateCreated) {
		this.playerId = playerId;
		this.userId = userId;
		this.summary = summary;
		this.grade = grade;
		this.dateCreated = dateCreated;
	}
	

	public long getId() {
		return id;
	}
	
	public String getSummary() {
		return summary;
	}

	public Double getGrade() {
		return grade;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public Long getPlayerId() {
		return playerId;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	

}
