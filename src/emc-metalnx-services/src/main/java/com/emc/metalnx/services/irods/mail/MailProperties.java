/**
 * 
 */
package com.emc.metalnx.services.irods.mail;

/**
 * Value object holding configured mail service properties from metalnx.config
 * 
 * @author Mike Conway - NIEHS
 *
 */
public class MailProperties {

	private String host = "";
	private int port = 22;
	private String username = "";
	private String password = "";
	private boolean startTlsEnable = false;
	private boolean smtpAuth = false;
	private String mailTransportProtocol = "";
	private String defaultEncoding = "UTF-8";
	private boolean debug = false;
	private boolean enabled = false;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStartTlsEnable() {
		return startTlsEnable;
	}

	public void setStartTlsEnable(boolean startTlsEnable) {
		this.startTlsEnable = startTlsEnable;
	}

	public boolean isSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(boolean smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getMailTransportProtocol() {
		return mailTransportProtocol;
	}

	public void setMailTransportProtocol(String mailTransportProtocol) {
		this.mailTransportProtocol = mailTransportProtocol;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDefaultEncoding() {
		return defaultEncoding;
	}

	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}

}
