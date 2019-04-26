package no.hvl.dat110.ac.rest;

import com.google.gson.Gson;

public class AccessMessage {

	private String message;
	
	public AccessMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static AccessMessage fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,AccessMessage.class);

    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
