package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/role")
public class RoleApi extends AbstractApi<Role, Long, String> {

		@Autowired
		private RoleService roleService;

		@Override
		@GetMapping
		public ResponseEntity findAll() {
				return ResponseEntity.ok(roleService.findAll());
		}

		@Override
		@PostMapping
		public ResponseEntity save(@RequestBody Role role, @RequestParam(name = "username") String username) {
				return ResponseEntity.ok(roleService.save(role, username));
		}

		@Override
		@PutMapping(value = "/{id}")
		public ResponseEntity update(@RequestBody Role role,
																															@PathVariable(name = "id") Long id,
																															@RequestParam(name = "username") String username) {
				if (roleService.update(role, id, username) == null) {
						ResponseEntity.badRequest().body("Can't find role by id: " + id);
				}
				return ResponseEntity.ok(roleService.update(role, id, username));
		}

		@Override
		@DeleteMapping(value = "/{id}")
		public ResponseEntity delete(@PathVariable(name = "id") Long id) {
				if (!roleService.delete(id)) {
						return ResponseEntity.badRequest().body("Can't find role by id: " + id);
				}
				roleService.delete(id);
				return ResponseEntity.ok().body("Role id: " + id + " was deleted");
		}
}
