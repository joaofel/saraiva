package com.joao.saraiva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

	private boolean isFree;
	
	private BestPrice bestPrice;

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public BestPrice getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(BestPrice bestPrice) {
		this.bestPrice = bestPrice;
	}
}
