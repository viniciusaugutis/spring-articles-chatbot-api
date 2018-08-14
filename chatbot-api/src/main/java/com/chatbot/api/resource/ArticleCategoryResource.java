package com.chatbot.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.api.model.ArticleCategory;
import com.chatbot.api.repository.ArticleCategoryRepository;

@RestController
@RequestMapping("/articles_category")
public class ArticleCategoryResource {

	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;

	@GetMapping
	public List<ArticleCategory> findAll() {
		return articleCategoryRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<ArticleCategory> create(@Valid @RequestBody ArticleCategory articleCategory) {
		ArticleCategory articleCategorySaved = articleCategoryRepository.save(articleCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(articleCategorySaved);
	}

}
