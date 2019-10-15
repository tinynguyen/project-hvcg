package com.congdat.notaryweb.api;

import com.congdat.notaryweb.model.News;
import com.congdat.notaryweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/news")
public class NewsApi extends AbstractApi<News, Long, String> {

		@Autowired
		private NewsService newsService;

		@Override
		@GetMapping
		public ResponseEntity findAll() {
				return ResponseEntity.ok(newsService.findAll());
		}

		@Override
		@PostMapping
		public ResponseEntity save(@RequestBody News news, @RequestParam(name = "username") String username) {
				return ResponseEntity.ok(newsService.save(news, username));
		}

		@Override
		@PutMapping(value = "/{id}")
		public ResponseEntity update(@RequestBody News news,
																															@PathVariable(name = "id") Long newsId,
																															@RequestParam(name = "username") String username) {
				if (newsService.update(news, newsId, username) == null) {
						ResponseEntity.badRequest().body("Can't find news by id: " + newsId);
				}
				return ResponseEntity.ok(newsService.update(news, newsId, username));
		}

		@Override
		@DeleteMapping(value = "/{id}")
		public ResponseEntity delete(@PathVariable(name = "id") Long id) {
				if (!newsService.delete(id)) {
						ResponseEntity.badRequest().body("Can't find news by id: " + id);
				}
				newsService.delete(id);
				return ResponseEntity.ok().body("News id: " + id + " was deleted");
		}
}
