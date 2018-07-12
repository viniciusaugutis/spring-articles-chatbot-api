package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.QuestionCategory;

public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, UUID> {

}
