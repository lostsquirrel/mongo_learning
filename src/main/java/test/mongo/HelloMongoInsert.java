package test.mongo;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

public class HelloMongoInsert {

	private static DB db;
	

	public static void main(String[] args) throws UnknownHostException, ParseException {
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://ubuntu.dev:27017"));
		db = client.getDB("test");
		
//		insertOne();
		insertMany();
		pringCount();
	}
	
	private static void pringCount() {
		DBCollection coll = db.getCollection("restaurants");
		System.out.println(coll.count());
	}
	
	private static void insertOne() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		
		DBObject arr = new BasicDBObject("address",
                new BasicDBObject()
                .append("street", "2 Avenue")
                .append("zipcode", "10075")
                .append("building", "1480")
                .append("coord", Arrays.asList(-73.9557413, 40.7720266)))
        .append("borough", "Manhattan")
        .append("cuisine", "Italian")
        .append("grades", Arrays.asList(
                new BasicDBObject()
                        .append("date", format.parse("2014-10-01T00:00:00Z"))
                        .append("grade", "A")
                        .append("score", 11),
                new BasicDBObject()
                        .append("date", format.parse("2014-01-16T00:00:00Z"))
                        .append("grade", "B")
                        .append("score", 17)))
        .append("name", "Vella")
        .append("restaurant_id", "41704620");
		WriteResult res = db.getCollection("restaurants").insert(arr);
		
		System.out.println(res);
	}
	
	private static void insertMany() {
		WriteResult res = db.getCollection("restaurants").insert(
				new BasicDBObject("restaurant_id", "001"),
				new BasicDBObject("restaurant_id", "002"),
				new BasicDBObject("restaurant_id", "003")
				);
		System.out.println(res);
	}

}
