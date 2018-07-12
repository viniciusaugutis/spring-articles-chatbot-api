package com.chatbot.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O nome da categoria de pergunta é um campo obrigatório")
	private String name;
	
	@NotNull(message = "A categoria da pergunta é obrigatória")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_category_id")
	private QuestionCategory questionCategory;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "question_keyword", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = {
				@JoinColumn(name = "keyword_id") })
	private List<Keyword> questionKeywords;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}

	public List<Keyword> getQuestionKeywords() {
		return questionKeywords;
	}

	public void setQuestionKeywords(List<Keyword> questionKeywords) {
		this.questionKeywords = questionKeywords;
	}

	public Question() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
