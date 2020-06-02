package com.project.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InboxDetails {
	@JsonProperty
	Integer num_inboxes;
	
	@JsonProperty
	List<Inbox> inboxes;
	 
	@JsonProperty 
	String status;

	public Integer getNum_inboxes() {
		return num_inboxes;
	}

	public void setNum_inboxes(Integer num_inboxes) {
		this.num_inboxes = num_inboxes;
	}

	public List<Inbox> getInboxes() {
		return inboxes;
	}

	public void setInboxes(List<Inbox> inboxes) {
		this.inboxes = inboxes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InboxDetails [num_inboxes=" + num_inboxes + ", inboxes="
				+ inboxes + ", status=" + status + "]";
	}
}
