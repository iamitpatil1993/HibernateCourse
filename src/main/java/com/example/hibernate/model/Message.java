package com.example.hibernate.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message implements Serializable {

	private static final long serialVersionUID = 9091518266617254576L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "message_id")
	private Long messageId;
	
	@Basic
	@Column(name = "message")
	private String message;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + "]";
	}
}
