package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

	Page<Topic> findByArticleCategoryId(Long articleCategoryId, Pageable pageable);

}
