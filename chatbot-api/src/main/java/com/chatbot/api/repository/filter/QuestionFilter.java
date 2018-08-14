package com.chatbot.api.repository.filter;

public class QuestionFilter {
	
	private Long articleCategoryId;
	
	private Boolean isValid;

	public Long getArticleCategoryId() {
		return articleCategoryId;
	}

	public void setArticleCategoryId(Long articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
