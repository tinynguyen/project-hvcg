package com.congdat.notaryweb.service.impl;

import com.congdat.notaryweb.model.News;
import com.congdat.notaryweb.model.User;
import com.congdat.notaryweb.repository.NewsRepository;
import com.congdat.notaryweb.repository.UserRepository;
import com.congdat.notaryweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

		@Autowired
		private NewsRepository newsRepository;

		@Autowired
		private UserRepository userRepository;

		@Override
		public List<News> findAll() {
				List<News> allNews = new ArrayList<>();
				newsRepository.findAll().forEach((allNews::add));
				return allNews;
		}

		@Override
		public News save(News news, String username) {
				User user = userRepository.findByUsername(username);
				news.setCreatedDate(new Date(System.currentTimeMillis()));
				news.setCreatedBy(username);
				news.setUser(user);
				return newsRepository.save(news);
		}

		@Override
		public News update(News news, Long newsId, String username) {
				News foundNews = newsRepository.findById(newsId).orElse(null);
				if (foundNews == null) {
						return null;
				}
				foundNews.setContent(news.getContent());
				foundNews.setTitle(news.getTitle());
				foundNews.setDescription(news.getDescription());
				foundNews.setThumbnail(news.getThumbnail());
				foundNews.setModifiedBy(username);
				foundNews.setModifiedDate(new Date(System.currentTimeMillis()));
				return newsRepository.save(foundNews);
		}

		@Override
		public boolean delete(Long id) {
				News foundNews = newsRepository.findById(id).orElse(null);
				if (foundNews == null) {
						return false;
				}
				newsRepository.deleteById(id);
				return true;
		}
}
