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

import com.chatbot.api.model.Keyword;
import com.chatbot.api.repository.KeywordRepository;

@RestController
@RequestMapping("/keywords")
public class KeywordResource {

	@Autowired
	private KeywordRepository keywordRepository;

	@GetMapping
	public List<Keyword> findAll() {
		return keywordRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Keyword> create(@Valid @RequestBody Keyword keyword) {
		Keyword keywordSaved = keywordRepository.save(keyword);
		return ResponseEntity.status(HttpStatus.CREATED).body(keywordSaved);
	}

}
