package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.Role;
import com.congdat.notaryweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/role")
public class RoleApi {

		@Autowired
		private RoleService roleService;

		@GetMapping
		public ResponseEntity findAll() {
				return ResponseEntity.ok(roleService.findAll());
		}

		@PostMapping
		ResponseEntity save(@RequestBody Role role) {
				return ResponseEntity.ok(roleService.save(role));
		}

		@PutMapping(value = "/{id}")
		ResponseEntity update(@RequestBody Role role, @PathVariable(name = "id") Long id) {
				return ResponseEntity.ok(roleService.update(role, id));
		}

		@DeleteMapping
		public void delete(@RequestParam(name = "id") Long id) {
				roleService.delete(id);
		}
}
