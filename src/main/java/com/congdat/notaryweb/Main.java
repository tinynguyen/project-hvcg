package com.congdat.notaryweb;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Main implements CommandLineRunner {

		@Autowired
		private RoleRepository roleRepository;

		public static void main(String[] args) {
				SpringApplication.run(Main.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
				List<Role> role = roleRepository.findAll();
				if(role.size() == 0) {
						Role userRole = new Role("User", "ROLE_USER", new ArrayList<>());
						userRole.setCreatedDate(new Date(System.currentTimeMillis()));
						roleRepository.save(userRole);
				}

		}
}
