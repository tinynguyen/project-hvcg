package com.congdat.notaryweb.service;

import com.congdat.notaryweb.model.Category;

import java.util.List;

public interface CategoryService {

		List<Category> findAll();

		Category save(Category category, String username);

		Category update(Category category, Long id, String username);

		boolean delete(Long id);
}
