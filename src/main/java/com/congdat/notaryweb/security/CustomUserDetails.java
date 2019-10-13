package com.congdat.notaryweb.security;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

		private User user;

		CustomUserDetails(User user) {
				this.user = user;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
				String roles = this.user.getRoles().stream().map(Role::getRole).reduce((x, y) -> x + "," + y).orElse("");
				return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		}

		@Override
		public String getPassword() {
				return this.user.getPassword();
		}

		@Override
		public String getUsername() {
				return this.user.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
				return true;
		}

		@Override
		public boolean isAccountNonLocked() {
				return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
				return true;
		}

		@Override
		public boolean isEnabled() {
				return this.user.getEnabled() == 1;
		}
}
