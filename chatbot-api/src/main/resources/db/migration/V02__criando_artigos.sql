CREATE EXTENSION IF NOT EXISTS pgcrypto;  

CREATE TABLE IF NOT EXISTS article (
	id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	title TEXT NOT NULL,
	content TEXT NOT NULL,
	seo_url TEXT,
	seo_meta_description TEXT,
	meta jsonb,
	created TIMESTAMP DEFAULT current_timestamp,
  	modified TIMESTAMP,
  	article_category_id INTEGER NOT NULL,
  	FOREIGN KEY (article_category_id) REFERENCES article_category(id)
);