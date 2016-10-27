package com.norulesweb.springapp.core.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Thin wrapper around Spring's ApplicationEventPublisher
 */
@Component
public class EventPublisher {

	@Autowired
	protected ApplicationEventPublisher applicationEventPublisher;

	public void publishEvent(String eventName, String topic, String subTopic, String subSubTopic, Object payload, Object messageKey) {
		publishEvent(eventName, topic + "." + subTopic + "." + subSubTopic, payload, messageKey);
	}

	public void publishEvent(String eventName, String topic, Object payload, Object messageKey) {
		applicationEventPublisher.publishEvent(new EventWrapper(eventName, topic, payload, messageKey));
	}
}
