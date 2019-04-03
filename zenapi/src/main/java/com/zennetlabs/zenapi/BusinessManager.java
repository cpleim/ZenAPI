package com.zennetlabs.zenapi;

import com.zennetlabs.zenapi.services.v1.User;

public class BusinessManager {

	// Singleton
	private static BusinessManager INSTANCE = new BusinessManager();

	public static BusinessManager getInstance() {
		return INSTANCE;
	}

	private BusinessManager() {

	}

	public User findUser(String userId) {
		System.out.print("[DEBUG INFO] BusinessManager::findUser -> Routine Started\n");
		User user = new User();
		user.setId("0001");
		user.setName("Juan Perez");
		return user;
	}

}
