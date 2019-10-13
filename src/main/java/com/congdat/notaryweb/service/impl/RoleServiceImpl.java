package com.congdat.notaryweb.service.impl;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.repository.RoleRepository;
import com.congdat.notaryweb.repository.UserRepository;
import com.congdat.notaryweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

		@Autowired
		private RoleRepository roleRepository;

		@Autowired
		private UserRepository userRepository;

		@Override
		public List<Role> findAll() {
				return roleRepository.findAll();
		}

		@Override
		public Role save(Role role) {
				return roleRepository.save(role);
		}

		@Override
		public Role update(Role role, long id) {
				Role foundRole = roleRepository.getOne(id);
				if (foundRole == null) {
						return null;
				}
				foundRole.setName(role.getName());
				foundRole.setRole(role.getRole());
				foundRole.setModifiedDate(new Date(System.currentTimeMillis()));
				return role;
		}

		@Override
		public void delete(long id) {
				roleRepository.deleteById(id);
		}
}
