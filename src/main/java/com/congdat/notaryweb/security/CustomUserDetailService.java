package com.congdat.notaryweb.security;

import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

		@Autowired
		private UserRepository userRepository;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userRepository.findByUsername(username);
				if (null == user) {
						throw new UsernameNotFoundException("leu leu");
				}
				return new CustomUserDetails(user);
		}
}
