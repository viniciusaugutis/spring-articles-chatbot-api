package com.chatbot.api.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.chatbot.api.model.json.JsonBinaryType;
import com.fasterxml.jackson.databind.JsonNode;


@Entity
@Table(name = "questionary")
public class Questionary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID id;

	@NotEmpty(message = "O nome do usuário é obrigatório")
	@Column(name = "user_name")
	private String userName;
	
	@NotEmpty(message = "O email do usuário é obrigatório")
	@Column(name = "user_email")
	@Email(message = "Insira um e-mail válido")
	private String userEmail;
	
	@Column(name = "content_result")
	private String contentResult;
	
	@Column(updatable = false)
	private LocalDateTime created;

	private LocalDateTime modified;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "article_id")
	private Article article;
	
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private JsonNode meta;
	
	@PrePersist
	public void setAttributePrePersist() {
		this.created = LocalDateTime.now();
	}

	@PreUpdate
	public void setAttributePreUpdate() {
		this.modified = LocalDateTime.now();
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getContentResult() {
		return contentResult;
	}

	public void setContentResult(String contentResult) {
		this.contentResult = contentResult;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public JsonNode getMeta() {
		return meta;
	}

	public void setMeta(JsonNode meta) {
		this.meta = meta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Questionary other = (Questionary) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
