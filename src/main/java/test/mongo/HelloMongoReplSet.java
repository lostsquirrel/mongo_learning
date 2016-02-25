package test.mongo;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HelloMongoReplSet {

	public static void main(String[] args) throws UnknownHostException {
		 MongoClient client = new MongoClient(Arrays.asList(
	                new ServerAddress("ubuntu.dev",27201),
	                new ServerAddress("ubuntu.dev",27202),
	                new ServerAddress("ubuntu.dev",27203)));
				 
				 DB db = client.getDB("test");
	        DBCollection coll = db.getCollection("test");
	        System.out.println(coll.count());
	}
}
