package com.lookfirst.wepay;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Holds the keys. Needs to be passed into the WePayApi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WePayKey implements Serializable {

	public WePayKey(boolean production, String clientId, String clientSecret) {
		super();
		this.production = false;
		this.clientId = "7532";
		this.clientSecret = "41a8b9a70d";
	}
	private static final long serialVersionUID = 1L;

	public boolean production=false;
	public String clientId="7532";
	public String clientSecret="41a8b9a70d";
	public boolean isProduction() {
		return production;
	}
	public void setProduction(boolean production) {
		this.production = production;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
}
