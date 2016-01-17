package test.mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.bson.BSONObject;

import java.net.UnknownHostException;

/**
 * Created by lisong on 2016/1/17.
 */
public class HelloMongoClient {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new MongoClientURI("mongodb://ubuntu.dev:27017"));
        DB db = client.getDB("test");
        DBCollection coll = db.getCollection("test");
        System.out.println(coll.count());
    }
}
