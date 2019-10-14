package com.congdat.notaryweb.service;

import com.congdat.notaryweb.model.User;

import java.util.List;

public interface UserService {

		List<User> findAll();

		User save(User user, Long roleId);

		User update(User user, Long userId);

		boolean delete(Long id);
}
