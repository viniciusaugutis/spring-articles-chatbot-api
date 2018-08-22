CREATE TABLE IF NOT EXISTS topic (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  article_category_id INTEGER NOT NULL,
  meta jsonb, 
  description TEXT,
  FOREIGN KEY (article_category_id) REFERENCES article_category(id)
);

CREATE TABLE IF NOT EXISTS question (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  topic_id INTEGER NOT NULL,
  meta jsonb, 
  is_valid BOOLEAN default 'true',
  FOREIGN KEY (topic_id) REFERENCES topic(id)
);