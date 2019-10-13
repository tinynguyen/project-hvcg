package com.congdat.notaryweb.service;

import com.congdat.notaryweb.model.User;

import java.util.List;

public interface UserService {

		List<User> findAll();

		User save(User user);

		User update(User user, long id);

		User delete(long id);
}
