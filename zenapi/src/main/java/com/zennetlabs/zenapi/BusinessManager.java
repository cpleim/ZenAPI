package com.zennetlabs.zenapi;

import java.util.ArrayList;
import java.util.List;

import com.zennetlabs.zenapi.services.v1.User;

public class BusinessManager {

	// Singleton
	private static BusinessManager INSTANCE = new BusinessManager();

	public static BusinessManager getInstance() {
		return INSTANCE;
	}

	private BusinessManager() {

	}

	public User findUsers(String userId) {
		System.out.print("[DEBUG INFO] BusinessManager::findUser -> Routine Started\n");
		User user = new User();
		user.setId("0001");
		user.setName("Juan Perez");
		return user;
	}

	public List<User> findUsers() {
		// This is some wacki way to add users...
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setId("0002");
		user1.setName("Jose Gimenez");
		User user2 = new User();
		user2.setId("0003");
		user2.setName("Carlos Alvarez");
		users.add(user1);
		users.add(user1);
		return users;
	}

	public User addUser(User user) {
		user.setId("1111");
		return null;
	}

	public User updateUserAttribute(String userId, String attribute, String value) {

		User user = new User();
		user.setId(userId);
		if (attribute.equals("name")) {
			user.setName(value);
		}
		return user;
	}

}
