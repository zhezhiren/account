package com.plj.domain.request.admin.sys;

import com.plj.domain.decorate.admin.sys.Menu;

public class MenuAdd extends Menu{
	
	private String url;
	
	private String channel;
	
	private String matchType;
	
	private String authType;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	
}
