package no.hvl.dat110.ac.rest;

import com.google.gson.Gson;

public class AccessCode {

	private int[] accesscode = {1,2}; // default access code
	
	public AccessCode() {
		
	}

	public int[] getAccesscode() {
		return accesscode;
	}

	public void setAccesscode(int[] accesscode) {
		this.accesscode = accesscode;
	}
	
	public static AccessCode fromJson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json,AccessCode.class);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
