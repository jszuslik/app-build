package com.norulesweb.springapp.core.event;

/**
 * A generic event wrapper to encapsulate event information that needs to be placed
 * on the event bus.
 */
public class EventWrapper {
	private String eventName;

	private String topic;

	private Object payload;

	private Object messageKey;

	public EventWrapper() { }

	public EventWrapper(String eventName, String topic, Object payload, Object messageKey) {
		setEventName(eventName);
		setTopic(topic);
		setPayload(payload);
		setMessageKey(messageKey);
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Object getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(Object messageKey) {
		this.messageKey = messageKey;
	}
}
