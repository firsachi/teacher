package com.mycompany.teacher.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="settings")
public class Settings implements Serializable {

	/**
	 * uid serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue()
	private int id;
	
	@Column(name="master")
	private String master;
	
	@Column(name="timeout")
	private String timeout;

	@Column(name="language")
	private String language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
