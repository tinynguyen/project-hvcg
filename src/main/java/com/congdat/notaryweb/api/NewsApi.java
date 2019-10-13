package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.News;
import com.congdat.notaryweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/news")
public class NewsApi {

		@Autowired
		private NewsService newsService;

		@GetMapping
		ResponseEntity findAll() {
				return ResponseEntity.ok(newsService.findAll());
		}

		@PostMapping
		ResponseEntity save(@RequestBody News news, @RequestParam(name = "username") String username) {
				return ResponseEntity.ok(newsService.save(news, username));
		}

		@PutMapping(value = "/{id}")
		ResponseEntity update(@RequestBody News news,
																								@PathVariable(name = "id") long newsId,
																								@RequestParam(name = "username") String username) {
				return ResponseEntity.ok(newsService.update(news, newsId, username));
		}

		@DeleteMapping(value = "/{id}")
		void delete(@PathVariable(name = "id") long id) {
				newsService.delete(id);
		}
}
