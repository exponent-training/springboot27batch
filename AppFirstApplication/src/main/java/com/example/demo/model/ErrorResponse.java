package com.example.demo.model;

public class ErrorResponse {
	
	private String errormsg;
	
	private String uri;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errormsg=" + errormsg + ", uri=" + uri + "]";
	} 
	
	
}
