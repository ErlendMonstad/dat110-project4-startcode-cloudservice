package no.hvl.dat110.ac.rest;

import com.google.gson.Gson;

public class AccessEntry {

	private Integer id;
	private String message;
	
	public AccessEntry(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toJson(){
	    Gson gson = new Gson();

	    return gson.toJson(this);
    }

	public static AccessEntry fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,AccessEntry.class);
    }


	
}
