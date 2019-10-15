package com.congdat.notaryweb.service.impl;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.repository.RoleRepository;
import com.congdat.notaryweb.repository.UserRepository;
import com.congdat.notaryweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private RoleRepository roleRepository;

		@Autowired
		private PasswordEncoder passwordEncoder;

		@Override
		public List<User> findAll() {
				return userRepository.findAll();
		}

		@Override
		public User save(User user, Long roleId) {
				Role role = roleRepository.findById(roleId).orElse(null);
				List<Role> roles = new ArrayList<>();
				roles.add(role);
				user.setRoles(roles);
				user.setCreatedBy(user.getUsername());
				user.setCreatedDate(new Date(System.currentTimeMillis()));
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepository.save(user);
		}

		@Override
		public User update(User user, Long id) {
				User foundUser = userRepository.findById(id).orElse(null);
				if (foundUser == null) {
						return null;
				}
				foundUser.setFullName(user.getFullName());
				foundUser.setUsername(user.getUsername());
				foundUser.setEmail(user.getEmail());
				foundUser.setPassword(passwordEncoder.encode(user.getPassword()));
				foundUser.setAvatar(user.getAvatar());
				foundUser.setModifiedDate(new Date(System.currentTimeMillis()));
				foundUser.setModifiedBy(user.getUsername());
				return userRepository.save(foundUser);
		}

		@Override
		public boolean delete(Long id) {
				User foundUser = userRepository.findById(id).orElse(null);
				if (foundUser == null) {
						return false;
				}
				foundUser.setEnabled(0);
				userRepository.save(foundUser);
				return true;
		}
}
