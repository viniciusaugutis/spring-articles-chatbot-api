package com.chatbot.api.resource;

import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.Hibernate;
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

import com.chatbot.api.model.Questionary;
import com.chatbot.api.repository.QuestionaryRepository;

@RestController
@RequestMapping("/questionaries")
public class QuestionaryResource {

	@Autowired
	private QuestionaryRepository questionaryRepository;

	@GetMapping
	public Page<Questionary> findAll(Pageable pageable) {
		Page<Questionary> pagesQuestionary = questionaryRepository.findAll(pageable);
		pagesQuestionary.getContent().forEach(item -> {
			Hibernate.initialize(item.getQuestionaryQuestions());
		});
		
		return pagesQuestionary;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Questionary> findById(@PathVariable UUID id) {
		Questionary questionary = questionaryRepository.findOne(id);
		if (questionary != null)
			return ResponseEntity.ok(questionary);
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Questionary> create(@Valid @RequestBody Questionary questionary) {
		Questionary questionarySaved = questionaryRepository.save(questionary);
		return ResponseEntity.status(HttpStatus.CREATED).body(questionarySaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Questionary> update(@PathVariable UUID id, @Valid @RequestBody Questionary questionary) {
		try {
			Questionary questionarySaved = questionaryRepository.save(questionary);
			return ResponseEntity.ok(questionarySaved);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			questionaryRepository.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
}
