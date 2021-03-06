package com.zennetlabs.zenapi;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.zennetlabs.zenapi.services.v1.User;

public class DataManager {

	private static DB zenapiDB;
	private static DBCollection userCollection;

	// Singleton
	private static DataManager INSTANCE;

	public static DataManager getIsntance() {
		if (INSTANCE == null) {
			INSTANCE = new DataManager();
		}
		return INSTANCE;
	}

	private DataManager() {
		try {
			MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
			zenapiDB = mongoClient.getDB("zenapi");
			userCollection = zenapiDB.getCollection("users");
		} catch (Exception e) {
			System.out.print("[ERROR] -> Database connection error. \n" + e);
		}

	}

	// Insert user into database
	public User insertUser(User user) {

		// get a document object
		BasicDBObject doc = new BasicDBObject();

		// add in name
		doc.put("name", user.getName());

		// insert user into users collection
		userCollection.insert(doc);

		// put new id into user object
		user.setId(doc.get("_id").toString());

		// return new object
		return user;

	}

	public User mapUserFromDBObject(DBObject dbObject) {
		User user = new User();
		user.setId(dbObject.get("_id").toString());
		user.setName((String) dbObject.get("name"));
		return user;
	}

	// Find user by id
	public User findUserById(String userIdString) {
		if (userIdString == null) {
			return null;
		}

		try {
			DBObject searchById = new BasicDBObject("_id", new ObjectId(userIdString));
			DBObject userObject = userCollection.findOne(searchById);
			if (userObject != null) {
				return mapUserFromDBObject(userObject);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.print("[ERROR] -> DataManager::findUserById Exception: \n" + e);
		}
		return null;
	}

	// Find all users
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			DBCursor cursor = userCollection.find();
			if (cursor != null) {
				while (cursor.hasNext()) {
					BasicDBObject doc = (BasicDBObject) cursor.next();
					User item = mapUserFromDBObject(doc);
					users.add(item);
				}
				return users;
			}
			return null;
		} catch (Exception e) {

		}
		return null;

	}

	//Update user attributes
	public User updateUserAttribute(String userId, String attribute, String value) {
		String updateValue = value;
		BasicDBObject doc = new BasicDBObject();
		doc.append("$set", new BasicDBObject().append(attribute, updateValue));
		DBObject searchById = new BasicDBObject("_id", new ObjectId(userId));
		userCollection.update(searchById, doc);
		return findUserById(userId);

	}

}
