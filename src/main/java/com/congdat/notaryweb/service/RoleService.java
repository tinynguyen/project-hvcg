package com.congdat.notaryweb.service;


import com.congdat.notaryweb.model.Role;

import java.util.List;

public interface RoleService {

		List<Role> findAll();

		Role save(Role Role, String username);

		Role update(Role Role, Long id, String username);

		boolean delete(Long id);
}
