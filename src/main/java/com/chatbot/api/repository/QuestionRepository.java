package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
	
	public Page<Question> findByTopicId(Long topicId, Pageable pageable);

}
