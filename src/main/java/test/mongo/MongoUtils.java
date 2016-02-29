package test.mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoUtils {

	public static DB db;
	
	static {
		MongoClient client;
		try {
			client = new MongoClient(new MongoClientURI("mongodb://ubuntu.dev:27017"));
			db = client.getDB("test");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
