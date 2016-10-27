package com.norulesweb.springapp.core.event.order;

/**
 * Event related to an Order
 */
public class OrderEvent {
	public static final String TOPIC = "order";

	public static final String EVENT_NEW_ORDER = "new_order";

	public static final String EVENT_STATUS_CHANGE = "order_status_change";

	protected Long id;

	protected String originatingId;

	protected int orderStatus;

	public OrderEvent() { }


	/**
	 * Order ID
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Originating system order ID
	 */
	public String getOriginatingId() {
		return originatingId;
	}

	public void setOriginatingId(String originatingId) {
		this.originatingId = originatingId;
	}

	/**
	 * Order status
	 */
	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
