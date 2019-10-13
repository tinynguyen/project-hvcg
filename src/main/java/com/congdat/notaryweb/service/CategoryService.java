package com.congdat.notaryweb.service;

import com.congdat.notaryweb.model.Category;

import java.util.List;

public interface CategoryService {

		List<Category> findAll();

		Category save(Category category);

		Category update(Category category, long id);

		void delete(long id);
}
