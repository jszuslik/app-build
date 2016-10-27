package com.norulesweb.springapp.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Listen for transactional application events - this is how events are raised by the core
 * services - they will be forwarded to the event bus here.
 */
@Component
public class EventListener {

	private static final Logger log = LoggerFactory.getLogger(EventListener.class);

//	@Autowired
//	protected EventSender eventSender;
//
//	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//	public void handleEvent(EventWrapper event) {
//		log.debug("handleEvent {} - {}", event.getEventName(), event.getTopic());
//		eventSender.send(event.getEventName(), event.getTopic(), event.getPayload(), event.getMessageKey());
//	}
}
