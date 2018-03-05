package com.vipinjoseph.assignmentconsumer.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {
	
	private Map<String, String> passwords = new HashMap<>();
	
	public UTPasswordCallback() {
		//TODO: use an LDAP Service to get the user name and password
	    this.passwords.put("guest", "guest");
	    this.passwords.put("admin", "password");
	}
			
			

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
			String password = passwords.get(passwordCallback.getIdentifier());
			if (password != null) {
				passwordCallback.setPassword(password);
				return;
			}
		}
		
	}

}
