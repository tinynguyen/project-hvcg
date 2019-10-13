package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserApi {

		@Autowired
		private UserService userService;

		@GetMapping
		@PostConstruct
		ResponseEntity findAll() {
				return ResponseEntity.ok(userService.findAll());
		}

		@PostMapping
		ResponseEntity save(@RequestBody User user) {
				return ResponseEntity.ok(userService.save(user));
		}

		@PutMapping(value = "/{id}")
		ResponseEntity update(@RequestBody User user, @PathVariable long id) {
					return ResponseEntity.ok(userService.update(user, id));
		}

		@DeleteMapping(value = "/{id}")
		ResponseEntity delete(@PathVariable long id) {
				return ResponseEntity.ok(userService.delete(id));
		}

}
