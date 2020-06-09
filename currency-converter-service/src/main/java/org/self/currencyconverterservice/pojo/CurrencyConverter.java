package org.self.currencyconverterservice.pojo;

public class CurrencyConverter {

	private int id;
	private String from;
	private String to;
	private Double exchangeFactor;
	private int port;
	private Double quantity;
	private Double convertedAmount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getExchangeFactor() {
		return exchangeFactor;
	}
	public void setExchangeFactor(Double exchangeFactor) {
		this.exchangeFactor = exchangeFactor;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public CurrencyConverter(int id, String from, String to, Double exchangeFactor, int port, Double quantity,
			Double convertedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeFactor = exchangeFactor;
		this.port = port;
		this.quantity = quantity;
		this.convertedAmount = convertedAmount;
	}
	public CurrencyConverter() {
		super();
	}
	@Override
	public String toString() {
		return "CurrencyConverter [id=" + id + ", from=" + from + ", to=" + to + ", exchangeFactor=" + exchangeFactor
				+ ", port=" + port + ", quantity=" + quantity + ", convertedAmount=" + convertedAmount + "]";
	}
	
}
