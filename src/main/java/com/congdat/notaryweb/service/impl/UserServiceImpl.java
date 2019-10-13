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

		private final long ROLE_USER_ID = 1L;

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private RoleRepository roleRepository;

		@Override
		public List<User> findAll() {
				return userRepository.findAll();
		}

		@Autowired
		private PasswordEncoder passwordEncoder;

		@Override
		public User save(User user) {
				Role role = roleRepository.findById(ROLE_USER_ID).orElse(null);
				List<Role> roles = new ArrayList<>();
				roles.add(role);
				user.setRoles(roles);
				user.setCreatedBy(user.getUsername()); // ???
				user.setCreatedDate(new Date(System.currentTimeMillis()));
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepository.save(user);
		}

		@Override
		public User update(User user, long id) {
				User foundUser = userRepository.findById(id).orElse(null);
				if (foundUser == null) {
						return null;
				}
				foundUser.setFullName(user.getFullName());
				foundUser.setUsername(user.getUsername());
				foundUser.setEmail(user.getEmail());
				foundUser.setPassword(user.getPassword());
				foundUser.setAvatar(user.getAvatar());
				return userRepository.save(foundUser);
		}

		@Override
		public User delete(long id) {
				User foundUser = userRepository.findById(id).orElse(null);
				if (foundUser == null) {
						return null;
				}
				foundUser.setEnabled(0);
				return userRepository.save(foundUser);
		}
}
