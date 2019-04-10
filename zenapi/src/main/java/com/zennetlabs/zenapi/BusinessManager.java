package com.zennetlabs.zenapi;

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

	public User findUsers(String userId) throws Exception {
		System.out.print("[DEBUG INFO] BusinessManager::findUser -> Routine Started\n");

		User user = DataManager.getIsntance().findUserById(userId);

		if (user == null) {
			throw new Exception("Nothing Found...");
		}
		return user;
	}

	public List<User> findUsers() {

		return DataManager.getIsntance().findAllUsers();
	}

	public User addUser(User user) {
		// Add to database
		User newUser = DataManager.getIsntance().insertUser(user);
		return newUser;
	}

	
	public User updateUserAttribute(String userId, String attribute, String value) {

		return DataManager.getIsntance().updateUserAttribute(userId, attribute, value);
	}

	
	public void deleteUser(String userId) {
//Not implemented yet!
		return;
	}

}
