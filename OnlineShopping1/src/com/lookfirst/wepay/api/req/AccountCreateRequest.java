package com.lookfirst.wepay.api.req;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.lookfirst.wepay.api.AccountUri;
import com.lookfirst.wepay.api.ThemeObject;

/**
 * https://stage.wepay.com/developer/reference/account
 *
 * Creates a new payment account for the user associated with the access token used to make this call.
 * If reference_id is passed, it MUST be unique for the application/user pair or an error will be returned.
 * NOTE: You cannot create an account with the word 'wepay' in it. This is to prevent phishing attacks.
 *
 * @author Jon Scott Stevens
 * @author Jeff Schnitzer
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AccountCreateRequest extends WePayRequest<AccountUri> {

	/** The name of the account you want to create. */
	private String name;
	/** The description of the account you want to create. */
	private String description;
	/** The reference id of the account. Must be unique for the application/user pair. */
	private String referenceId;
	/** The uri for an image that you want to use for the accounts icon. This image will be used in the co-branded checkout process. */
	private String imageUri;
	/** The list of Google Analytics account ids that WePay will throw events to and use for tracking. */
	private List<String> gaqDomains;
	/** The theme object you want to be used for account's checkout flows, withdrawal flows, and emails */
	private ThemeObject themeObject;

	public AccountCreateRequest(String name, String description,
			String referenceId, String imageUri, List<String> gaqDomains,
			ThemeObject themeObject) {
		super();
		this.name = name;
		this.description = description;
		this.referenceId = referenceId;
		this.imageUri = imageUri;
		this.gaqDomains = gaqDomains;
		this.themeObject = themeObject;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * @return the imageUri
	 */
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * @param imageUri the imageUri to set
	 */
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	/**
	 * @return the gaqDomains
	 */
	public List<String> getGaqDomains() {
		return gaqDomains;
	}

	/**
	 * @param gaqDomains the gaqDomains to set
	 */
	public void setGaqDomains(List<String> gaqDomains) {
		this.gaqDomains = gaqDomains;
	}

	/**
	 * @return the themeObject
	 */
	public ThemeObject getThemeObject() {
		return themeObject;
	}

	/**
	 * @param themeObject the themeObject to set
	 */
	public void setThemeObject(ThemeObject themeObject) {
		this.themeObject = themeObject;
	}

	/** */
	@Override
	public String getEndpoint() {
		return "/account/create";
	}
}