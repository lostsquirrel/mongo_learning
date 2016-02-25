package test.mongo;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Created by lisong on 2016/1/17.
 */
public class HelloMongoClient {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new MongoClientURI("mongodb://ubuntu.dev:27201,ubuntu.dev:27202,ubuntu.dev:27203"));
        DB db = client.getDB("test");
        DBCollection coll = db.getCollection("test");
        System.out.println(coll.count());
    }
}
