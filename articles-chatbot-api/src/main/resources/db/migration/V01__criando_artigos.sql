CREATE EXTENSION IF NOT EXISTS pgcrypto;  

CREATE TABLE IF NOT EXISTS article (
	id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	title TEXT NOT NULL,
	content TEXT NOT NULL,
	seo_url TEXT,
	seo_meta_description TEXT,
	meta JSONB,
	created TIMESTAMP DEFAULT current_timestamp,
  	modified TIMESTAMP
);