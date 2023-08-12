package com.example.demo.model;

public class ExchangeRequest {
	
	private int id;
	
	private String from;
	
	private String to;
	
    private float exchangeRate;
    
    private double exchangeAmount; 

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

	public float getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	
	public double getExchangeAmount() {
		return exchangeAmount;
	}

	public void setExchangeAmount(double exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}

	@Override
	public String toString() {
		return "ExchangeRequest [id=" + id + ", from=" + from + ", to=" + to + ", exchangeRate=" + exchangeRate
				+ ", exchangeAmount=" + exchangeAmount + "]";
	}
    
    
}
