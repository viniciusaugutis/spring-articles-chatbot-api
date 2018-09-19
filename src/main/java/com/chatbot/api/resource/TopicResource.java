package com.chatbot.api.resource;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.api.model.Question;
import com.chatbot.api.model.Topic;
import com.chatbot.api.repository.TopicRepository;
import com.chatbot.api.repository.filter.TopicFilter;

@RestController
@RequestMapping("/topics")
public class TopicResource {

	@Autowired
	private TopicRepository topicRepository;

	@GetMapping
	public Page<Topic> findAll(TopicFilter topicFilter, Pageable pageable) {
		if (topicFilter.getArticleCategoryId() == null) {
			return topicRepository.findAll(pageable);
		} else {
			return topicRepository.findByArticleCategoryId(topicFilter.getArticleCategoryId(), pageable);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Topic> findById(@PathVariable UUID id) {
		Topic topic = topicRepository.findOne(id);
		if (topic != null)
			return ResponseEntity.ok(topic);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Topic> create(@Valid @RequestBody Topic topic) {
		Topic topicSaved = topicRepository.save(topic);
		return ResponseEntity.status(HttpStatus.CREATED).body(topicSaved);
	}

}
