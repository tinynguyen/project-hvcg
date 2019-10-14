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
		public Role save(Role role, String username) {
				role.setCreatedDate(new Date(System.currentTimeMillis()));
				role.setCreatedBy(username);
				return roleRepository.save(role);
		}

		@Override
		public Role update(Role role, Long id, String username) {
				Role foundRole = roleRepository.findById(id).orElse(null);
				if (foundRole == null) {
						return null;
				}
				foundRole.setName(role.getName());
				foundRole.setRole(role.getRole());
				foundRole.setModifiedDate(new Date(System.currentTimeMillis()));
				foundRole.setModifiedBy(username);
				return roleRepository.save(foundRole);
		}

		@Override
		public boolean delete(Long id) {
				Role foundCategory = roleRepository.findById(id).orElse(null);
				if (foundCategory == null) {
						return false;
				}
				roleRepository.deleteById(id);
				return true;
		}
}
