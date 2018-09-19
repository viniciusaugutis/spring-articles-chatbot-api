package com.chatbot.api.resource;

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
import com.chatbot.api.repository.ArticleRepository;

@RestController
@RequestMapping("/articles")
public class ArticleResource {

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping
	public Page<Article> findAll(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> findById(@PathVariable UUID id) {
		Article article = articleRepository.findOne(id);
		if (article != null)
			return ResponseEntity.ok(article);
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Article> create(@Valid @RequestBody Article article) {
		Article articleSaved = articleRepository.save(article);
		return ResponseEntity.status(HttpStatus.CREATED).body(articleSaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> update(@PathVariable UUID id, @Valid @RequestBody Article article) {
		try {
			Article savedArticle = articleRepository.save(article);
			return ResponseEntity.ok(savedArticle);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			articleRepository.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
}
