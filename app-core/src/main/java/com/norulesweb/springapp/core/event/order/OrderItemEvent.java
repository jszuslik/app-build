package com.norulesweb.springapp.core.event.order;

/**
 * Event related to an OrderItem
 */
public class OrderItemEvent {
	public static final String TOPIC = "order_item";

	public static final String EVENT_STATUS_CHANGE = "order_item_status_change";

	private Long id;

	private int orderItemStatus;

	private String externalPatientId;

	private String externalTrackingId;

	private String externalItemId;

	private Long orderId;

	private String originatingOrderId;

	private int quantity;

	private int quantityShipped;

	private int quantityCancelled;

	public OrderItemEvent() { }

	/**
	 * Order item ID
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Order item status
	 */
	public int getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(int orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	/**
	 * Patient ID associated with the item in the ordering system
	 */
	public String getExternalPatientId() {
		return externalPatientId;
	}

	public void setExternalPatientId(String externalPatientId) {
		this.externalPatientId = externalPatientId;
	}

	/**
	 * Tracking identifier associated with the item in the ordering system
	 */
	public String getExternalTrackingId() {
		return externalTrackingId;
	}

	public void setExternalTrackingId(String externalTrackingId) {
		this.externalTrackingId = externalTrackingId;
	}

	/**
	 * Line item identifier associated with the item in the ordering system
	 */
	public String getExternalItemId() {
		return externalItemId;
	}

	public void setExternalItemId(String externalItemId) {
		this.externalItemId = externalItemId;
	}

	/**
	 * Quantity ordered
	 */
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Quantity currently shipped
	 */
	public int getQuantityShipped() {
		return quantityShipped;
	}

	public void setQuantityShipped(int quantityShipped) {
		this.quantityShipped = quantityShipped;
	}

	/**
	 * Quantity currently cancelled
	 */
	public int getQuantityCancelled() {
		return quantityCancelled;
	}

	public void setQuantityCancelled(int quantityCancelled) {
		this.quantityCancelled = quantityCancelled;
	}

	/**
	 * Order ID for this order item
	 */
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Order ID from the originating system
	 */
	public String getOriginatingOrderId() {
		return originatingOrderId;
	}

	public void setOriginatingOrderId(String originatingOrderId) {
		this.originatingOrderId = originatingOrderId;
	}
}
