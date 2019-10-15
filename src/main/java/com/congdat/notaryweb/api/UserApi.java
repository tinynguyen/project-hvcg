package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserApi {

		@Autowired
		private UserService userService;

		@GetMapping
		public ResponseEntity findAll() {
				return ResponseEntity.ok(userService.findAll());
		}

		@PostMapping
		public ResponseEntity save(@RequestBody User user, @RequestParam(name = "id") Long roleId) {
				return ResponseEntity.ok(userService.save(user, roleId));
		}

		@PutMapping(value = "/{id}")
		public ResponseEntity update(@RequestBody User user,
																															@PathVariable(name = "id") Long userId) {
				if (userService.update(user, userId) == null) {
						return ResponseEntity.badRequest().body("Can't find user by id: " + userId);
				}
				return ResponseEntity.ok(userService.update(user, userId));
		}

		@DeleteMapping(value = "/{id}")
		public ResponseEntity delete(@PathVariable(name = "id") Long userId) {
				if (!userService.delete(userId)) {
						return ResponseEntity.badRequest().body("Can't find user by id: " + userId);
				}
				userService.delete(userId);
				return ResponseEntity.ok().body("User id: " + userId + " was deleted");
		}


}
