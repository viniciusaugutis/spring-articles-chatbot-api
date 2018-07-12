package com.chatbot.api.resource;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.api.model.Article;
import com.chatbot.api.model.QuestionCategory;
import com.chatbot.api.repository.ArticleRepository;
import com.chatbot.api.repository.QuestionCategoryRepository;

@RestController
@RequestMapping("/questions_category")
public class QuestionCategoryResource {

	@Autowired
	private QuestionCategoryRepository questionCategoryRepository;

	@GetMapping
	public List<QuestionCategory> findAll() {
		return questionCategoryRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<QuestionCategory> create(@Valid @RequestBody QuestionCategory questionCategory) {
		QuestionCategory questionCategorySaved = questionCategoryRepository.save(questionCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(questionCategorySaved);
	}

}
