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

import com.chatbot.api.model.Question;
import com.chatbot.api.repository.QuestionRepository;
import com.chatbot.api.repository.filter.QuestionFilter;

@RestController
@RequestMapping("/questions")
public class QuestionResource {

	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping
	public Page<Question> findAll(QuestionFilter questionFilter, Pageable pageable) {
		if (questionFilter.getTopicId() == null) {
			return questionRepository.findAll(pageable);
		} else {
			return questionRepository.findByTopicId(questionFilter.getTopicId(), pageable);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> findById(@PathVariable UUID id) {
		Question question = questionRepository.findOne(id);
		if (question != null)
			return ResponseEntity.ok(question);
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		Question questionSaved = questionRepository.save(question);
		return ResponseEntity.status(HttpStatus.CREATED).body(questionSaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Question> update(@PathVariable UUID id, @Valid @RequestBody Question question) {
		try {
			Question questionSaved = questionRepository.save(question);
			return ResponseEntity.ok(questionSaved);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			questionRepository.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
