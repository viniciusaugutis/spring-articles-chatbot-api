CREATE TABLE IF NOT EXISTS questionary (
	id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	user_name TEXT NOT NULL,
	user_email TEXT NOT NULL,
	content_result TEXT,
	article_id UUID,
	meta jsonb,
	created TIMESTAMP DEFAULT current_timestamp,
	FOREIGN KEY (article_id) REFERENCES article(id),
  	modified TIMESTAMP
);