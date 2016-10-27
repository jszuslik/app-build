package com.norulesweb.springapp.core.event.order;

/**
 * Event related to a SupplierOrder
 */
public class SupplierOrderEvent {
	public static final String TOPIC = "supplier_order";

	public static final String EVENT_STATUS_CHANGE = "supplier_order_status_change";

	public static final String EVENT_IDENTIFIER_CHANGE = "supplier_order_identifier_change";

	public static final String EVENT_NEW_SUPPLIER_ORDER = "new_supplier_order";

	private Long id;

	private int supplierOrderStatus;

	private String supplierWorkflowStatusCode;

	private String supplierWorkflowStatusDescription;

	private String supplierOrderIdentifier;

	private Long supplierId;

	private Long orderId;

	private String originatingOrderId;

	public SupplierOrderEvent() { }

	/**
	 * SupplierOrder ID
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Current SupplierOrder status
	 */
	public int getSupplierOrderStatus() {
		return supplierOrderStatus;
	}

	public void setSupplierOrderStatus(int supplierOrderStatus) {
		this.supplierOrderStatus = supplierOrderStatus;
	}

	/**
	 * The supplier's workflow status code
	 */
	public String getSupplierWorkflowStatusCode() {
		return supplierWorkflowStatusCode;
	}

	public void setSupplierWorkflowStatusCode(String supplierWorkflowStatusCode) {
		this.supplierWorkflowStatusCode = supplierWorkflowStatusCode;
	}

	/**
	 * Description of the supplier's workflow status
	 */
	public String getSupplierWorkflowStatusDescription() {
		return supplierWorkflowStatusDescription;
	}

	public void setSupplierWorkflowStatusDescription(String supplierWorkflowStatusDescription) {
		this.supplierWorkflowStatusDescription = supplierWorkflowStatusDescription;
	}

	/**
	 * Supplier's identifier for this order
	 */
	public String getSupplierOrderIdentifier() {
		return supplierOrderIdentifier;
	}

	public void setSupplierOrderIdentifier(String supplierOrderIdentifier) {
		this.supplierOrderIdentifier = supplierOrderIdentifier;
	}

	/**
	 * Supplier ID
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * Order ID this SupplierOrder is related to
	 */
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Orignating system's order ID this SupplierOrder is related to
	 */
	public String getOriginatingOrderId() {
		return originatingOrderId;
	}

	public void setOriginatingOrderId(String originatingOrderId) {
		this.originatingOrderId = originatingOrderId;
	}
}
