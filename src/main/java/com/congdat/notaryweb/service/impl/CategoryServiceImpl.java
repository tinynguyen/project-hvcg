package com.congdat.notaryweb.service.impl;

import com.congdat.notaryweb.model.Category;
import com.congdat.notaryweb.repository.CategoryRepository;
import com.congdat.notaryweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

		@Autowired
		private CategoryRepository categoryRepository;

		@Override
		public List<Category> findAll() {
				List<Category> categories = new ArrayList<>();
				categoryRepository.findAll().forEach(categories::add);
				return categories;
		}

		@Override
		public Category save(Category category, String username) {
				category.setCreatedDate(new Date(System.currentTimeMillis()));
				category.setCreatedBy(username);
				return categoryRepository.save(category);
		}

		@Override
		public Category update(Category category, Long id, String username) {
				Category foundCategory = categoryRepository.findById(id).orElse(null);
				if (foundCategory == null) {
						return null;
				}
				foundCategory.setName(category.getName());
				foundCategory.setDescription(category.getDescription());
				foundCategory.setModifiedDate(new Date(System.currentTimeMillis()));
				foundCategory.setModifiedBy(username);
				return categoryRepository.save(foundCategory);
		}

		@Override
		public boolean delete(Long id) {
				Category foundCategory = categoryRepository.findById(id).orElse(null);
				if (foundCategory == null) {
						return false;
				}
				categoryRepository.deleteById(id);
				return true;
		}
}
