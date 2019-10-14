package com.congdat.notaryweb.service;

import com.congdat.notaryweb.model.News;

import java.util.List;

public interface NewsService {

		List<News> findAll();

		News save(News news, String username);

		News update(News news, Long newsId, String username);

		boolean delete(Long id);

}
