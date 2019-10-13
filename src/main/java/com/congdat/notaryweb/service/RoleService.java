package com.congdat.notaryweb.service;


import com.congdat.notaryweb.model.Role;

import java.util.List;

public interface RoleService {

		List<Role> findAll();

		Role save(Role Role);

		Role update(Role Role, long id);

		void delete(long id);
}
