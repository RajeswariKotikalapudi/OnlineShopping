package com.pc.onlineshopping.action;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.lookfirst.wepay.WePayApi;
import com.lookfirst.wepay.WePayException;
import com.lookfirst.wepay.WePayKey;
import com.lookfirst.wepay.api.Token;
import com.lookfirst.wepay.api.WePayUser;
import com.lookfirst.wepay.api.req.AccountCreateRequest;
import com.lookfirst.wepay.api.req.UserRequest;
import com.lookfirst.wepay.api.req.WePayRequest;
import com.pc.onlineshopping.entities.Account;
import com.pc.onlineshopping.entities.Login;

@ManagedBean(name = "loginAction")
@ApplicationScoped
public class LoginAction {

	private Login login = null;
	private Account account = null;

	String clientId = "7532";
	String clientSecret = "41a8b9a70d";
	boolean production = false;
	String code = "80332c78bc469478418f0eb066e60501f4f681e649c03a1918";
	String authRedirectUrl = "http://192.168.3.15:8080/OnlineShopping/";
	// http://192.168.3.15:8080/OnlineShopping/
	String myState = "registered";

	FacesContext context;

	// private String username;

	public LoginAction() {
		login = new Login();
		account = new Account();

	}

	/*
	 * public String login(){ username = login.getUsername(); String password =
	 * login.getPassword();
	 * //UserService.session.setAttribute("username",username); String uname =
	 * userService.verifylogincredentials(username,password);
	 * if(uname.equals(username)){
	 * 
	 * boolean verify = userService.veryActivationStatus(username); if (verify
	 * == true) { return "welcome"; } else return "verifyemail"; }else return
	 * "login"; }
	 */

	/**
	 * @return Login class object
	 */
	public Login getLogin() {
		if (this.login == null) {
			login = new Login();
		}

		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String register() {
		FacesContext.getCurrentInstance().addMessage("register",
				new FacesMessage("Succes!"));
		FacesContext context = FacesContext.getCurrentInstance();
		String uname = login.getUsername();

		int uid = login.getUserId();

		String fromUserName = login.getUsername();
		System.out.println("fromUserName:" + fromUserName);

		String toMailID = login.getEmailAddress();
		System.out.println("toMailID:" + toMailID);

		return "welcome";
	}

	public Account getAccount() {
		if (this.account == null) {
			account = new Account();
		}
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String createAccount() throws WePayException, IOException {
		
		WePayApi api = new WePayApi(new WePayKey(production,clientId,clientSecret));
		String url = api.getAuthorizationUri(com.lookfirst.wepay.WePayApi.Scope.getAll(), authRedirectUrl,myState, login.getUsername(), login.getEmailAddress());
		System.out.println("url:" + url);
		// Use the code to generate a token.
		Token token = api.getToken(code, authRedirectUrl);
		System.out.println("token:" + token);
		WePayUser user = api.execute(token.getAccessToken(), new UserRequest());
		System.out.println("user:" + user);
		System.out.println("username" + user.getFirstName());
		WePayRequest acr = new AccountCreateRequest(account.getName(),account.getDescription(), account.getReferenceId(), null, null,
				null);
		System.out.println("account created" + acr);
		System.out.println(acr.getEndpoint());
		return null;

	}

}
