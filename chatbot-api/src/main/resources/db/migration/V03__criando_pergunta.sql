CREATE TABLE IF NOT EXISTS question (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  article_category_id INTEGER NOT NULL,
  meta jsonb, 
  is_valid BOOLEAN default 'true',
  FOREIGN KEY (article_category_id) REFERENCES article_category(id)
);