package test.mongo;

import java.util.Arrays;
import java.util.function.Consumer;

import org.bson.BSONObject;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class HelloMongoFind {

	private final String COL = "restaurants";
	
	@Test
	public void testFindAll() {
		DBCursor xx = MongoUtils.db.getCollection(COL).find();
		print(xx);
	}
	
	@Test
	public void findByTopLevel() {
		DBObject q = new BasicDBObject("borough", "Manhattan");
		DBCursor xx = find(q);
		print(xx);
	}
	
	@Test
	public void findByEmboddedDoc() {
		DBObject q = new BasicDBObject("address.zipcode", "10075");
		DBCursor xx = find(q);
		print(xx);
	}
	
	@Test
	public void findInArray() {
		DBObject q = new BasicDBObject("grades.grade", "B");
		DBCursor xx = find(q);
		print(xx);
	}
	
	@Test
	public void findByGreaterThan() {
		DBObject q = new BasicDBObject("grades.score", new BasicDBObject("$gt", 30));
		DBCursor xx = find(q);
		print(xx);
	}
	
	@Test
	public void findByLessThan() {
		DBObject q = new BasicDBObject("grades.score", new BasicDBObject("$lt", 10));
		DBCursor xx = find(q);
		print(xx);
	}
	
	@Test
	public void findWithAnd() {
		DBObject q = new BasicDBObject(
				 "cuisine", "Italian").append("address.zipcode", "10075");
		DBCursor xx = find(q);
		print(xx);
	}
	
	
	@Test
	public void findWithOr() {
		DBObject q = new BasicDBObject("$or",
				Arrays.asList(new BasicDBObject("cuisine", "Italian"), 
						new BasicDBObject("address.zipcode", "10075"))
				);
		DBCursor xx = find(q);
		print(xx);
		
	}
	
	@Test
	public void findWithSort() throws Exception {
		DBCursor xx = MongoUtils.db.getCollection(COL).find().
				sort(new BasicDBObject("borough", 1).append("address.zipcode", 1));
		print(xx);
	}
	
	private void print(DBCursor xx) {
		Consumer<BSONObject> gg = new Consumer<BSONObject>(){
	
			@Override
			public void accept(BSONObject t) {
				System.out.println(t);
			}
	
		};
		xx.forEach(gg);
		System.out.println(xx.count());
	}

	private DBCursor find(DBObject q) {
		return MongoUtils.db.getCollection(COL).find(q);
	}
}
