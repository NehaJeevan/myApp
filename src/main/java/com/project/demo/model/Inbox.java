package com.project.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inbox {

	//"id":10,"number":919220592205,"keyword":"YR3CL","num_messages":0,"num_contacts":0,"inboxName":"","newMsgs":0,"isMyDND":"n"
	@JsonProperty
	Integer id;
	
	@JsonProperty
	Long number;
	
	@JsonProperty
	String keyword;
	
	@JsonProperty
	Integer num_messages;
	
	@JsonProperty
	Integer num_contacts;
	
	@JsonProperty
	String inboxName;
	
	@JsonProperty
	Integer newMsgs;
	
	@JsonProperty
	String isMyDND;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getNum_messages() {
		return num_messages;
	}

	public void setNum_messages(Integer num_messages) {
		this.num_messages = num_messages;
	}

	public Integer getNum_contacts() {
		return num_contacts;
	}

	public void setNum_contacts(Integer num_contacts) {
		this.num_contacts = num_contacts;
	}

	public String getInboxName() {
		return inboxName;
	}

	public void setInboxName(String inboxName) {
		this.inboxName = inboxName;
	}

	public Integer getNewMsgs() {
		return newMsgs;
	}

	public void setNewMsgs(Integer newMsgs) {
		this.newMsgs = newMsgs;
	}

	public String getIsMyDND() {
		return isMyDND;
	}

	public void setIsMyDND(String isMyDND) {
		this.isMyDND = isMyDND;
	}

	@Override
	public String toString() {
		return "Inbox [id=" + id + ", number=" + number + ", keyword="
				+ keyword + ", num_messages=" + num_messages
				+ ", num_contacts=" + num_contacts + ", inboxName=" + inboxName
				+ ", newMsgs=" + newMsgs + ", isMyDND=" + isMyDND + "]";
	}
	
	
}
