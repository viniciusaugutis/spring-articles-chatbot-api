package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.ArticleCategory;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, UUID> {

}
