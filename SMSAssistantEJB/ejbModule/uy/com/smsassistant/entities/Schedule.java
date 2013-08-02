package uy.com.smsassistant.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

	private static final long serialVersionUID = -515336135058000411L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "box_id")
	private String boxId;
	
	@Column(name = "received_message")
	private String receivedMessage;
	
	@Column(name = "message_to_send")
	private String messageToSend;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getReceivedMessage() {
		return receivedMessage;
	}

	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}

	public String getMessageToSend() {
		return messageToSend;
	}

	public void setMessageToSend(String messageToSend) {
		this.messageToSend = messageToSend;
	}
}