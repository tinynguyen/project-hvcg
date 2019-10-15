package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.Category;
import com.congdat.notaryweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryApi extends AbstractApi<Category, Long, String> {

		@Autowired
		private CategoryService categoryService;

		@Override
		@GetMapping
		public ResponseEntity findAll() {
				return ResponseEntity.ok(categoryService.findAll());
		}

		@Override
		@PostMapping
		public ResponseEntity save(@RequestBody Category agr, @RequestParam(name = "username") String username) {
				return ResponseEntity.ok(categoryService.save(agr, username));
		}

		@Override
		@PutMapping(value = "/{id}")
		public ResponseEntity update(@RequestBody Category agr,
																															@PathVariable(name = "id") Long id,
																															@RequestParam(name = "username") String username) {
				if (categoryService.update(agr, id, username) == null) {
						return ResponseEntity.badRequest().body("Can't find category by id: " + id);
				}
				return ResponseEntity.ok(categoryService.update(agr, id, username));
		}

		@Override
		@DeleteMapping(value = "/{id}")
		public ResponseEntity delete(@PathVariable(name = "id") Long id) {
				if (!categoryService.delete(id)) {
						return ResponseEntity.badRequest().body("Can't find category by id: " + id);
				}
				categoryService.delete(id);
				return ResponseEntity.ok().body("Category id: " + id + " was deleted");
		}
}
