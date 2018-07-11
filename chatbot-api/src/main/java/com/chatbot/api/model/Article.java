package com.chatbot.api.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.NotEmpty;

import com.chatbot.api.model.json.JsonBinaryType;
import com.fasterxml.jackson.databind.JsonNode;

@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })

@Entity
@Table(name = "article")
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID id;

	@NotEmpty(message = "O título do artigo é obrigatório")
	private String title;
	
	@NotEmpty(message = "O conteúdo do artigo é obrigatório")
	private String content;
	
	@Column(name = "seo_url")
	private String seoUrl;
	
	@Column(name = "seo_meta_description")
	private String seoMetaDescription;
	
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private JsonNode meta;
	
	@Column(updatable = false)
	private LocalDateTime created;

	private LocalDateTime modified;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSeoUrl() {
		return seoUrl;
	}

	public void setSeoUrl(String seoUrl) {
		this.seoUrl = seoUrl;
	}

	public String getSeoMetaDescription() {
		return seoMetaDescription;
	}

	public void setSeoMetaDescription(String seoMetaDescription) {
		this.seoMetaDescription = seoMetaDescription;
	}

	public JsonNode getMeta() {
		return meta;
	}

	public void setMeta(JsonNode meta) {
		this.meta = meta;
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
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
