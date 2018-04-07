package com.joao.saraiva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.joao.saraiva.deserializer.FloatDecimalDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BestPrice {

	@JsonDeserialize(using = FloatDecimalDeserializer.class)
	private float value;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
