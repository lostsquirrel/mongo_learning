package test.mongo;

import java.util.Date;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class TestMongoUpdate {

	private final String COL = "restaurants";
	
	@Test
	public void testUpdateTopLevelFields() throws Exception {
		DBObject q = new BasicDBObject("name", "Juni");
		DBObject o = new BasicDBObject("$set", 
				new BasicDBObject("cuisine", "American (New)").
				append("lastModified", new Date())
				);
		WriteResult res = MongoUtils.db.getCollection(COL).update(q , o);
		
		System.out.println(res);
	}
	
	@Test
	public void testUpdateEmbodedFields() throws Exception {
		DBObject q = new BasicDBObject("restaurant_id", "41156888");
		DBObject o = new BasicDBObject("$set", 
				new BasicDBObject("address.street", "East 31st Street").
				append("lastModified", new Date())
				);
		WriteResult res = MongoUtils.db.getCollection(COL).update(q , o);
		
		System.out.println(res);
	}
}
