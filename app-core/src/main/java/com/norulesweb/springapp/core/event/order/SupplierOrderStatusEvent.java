package com.norulesweb.springapp.core.event.order;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Event related to a supplier order status query
 */
public class SupplierOrderStatusEvent {
	private Long supplierOrderId;

	private Set<Long> orderItemIds;

	public SupplierOrderStatusEvent() { }

	/**
	 * The SupplierOrder ID this event relates to
	 */
	public Long getSupplierOrderId() {
		return supplierOrderId;
	}

	public void setSupplierOrderId(Long supplierOrderId) {
		this.supplierOrderId = supplierOrderId;
	}

	/**
	 * List of OrderItems that need status checked
	 */
	public Set<Long> getOrderItemIds() {
		return orderItemIds;
	}

	public void setOrderItemIds(Set<Long> orderItemIds) {
		this.orderItemIds = orderItemIds;
	}

	public void addOrderItemId(Long id) {
		if (this.orderItemIds == null)
			this.orderItemIds = new HashSet<>();

		orderItemIds.add(id);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("supplierOrderId", supplierOrderId)
				.append("orderItemIds", orderItemIds)
				.toString();
	}
}
