package com.chatbot.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.api.model.Questionary;

public interface QuestionaryRepository extends JpaRepository<Questionary, UUID> {

}
