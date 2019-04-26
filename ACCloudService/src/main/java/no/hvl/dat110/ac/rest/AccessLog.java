package no.hvl.dat110.ac.rest;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;

import javax.swing.text.html.Option;

public class AccessLog {
	
	private AtomicInteger cid;
	protected ConcurrentHashMap<Integer, AccessEntry> log;
	
	public AccessLog () {
		this.log = new ConcurrentHashMap<Integer,AccessEntry>();
		cid = new AtomicInteger(0);
	}

	public int add(String message) {

		int id = log.size();
		log.put(id,new AccessEntry(id,message));

		return id;
	}
		
	public Optional<AccessEntry> get(int id) {
	    if(log.containsKey(id))
	        return Optional.of(log.get(id));
	    else
	        return Optional.empty();
	}
	
	public void clear() {
		log.clear();
	}
	
	public String toJson () {
        Gson gson = new Gson();
		String json = gson.toJson(log.values());
    	
    	return json;
    }
}
