package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, UUID> {

}
