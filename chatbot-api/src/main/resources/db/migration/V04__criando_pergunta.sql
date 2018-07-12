CREATE TABLE IF NOT EXISTS question (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  question_category_id INTEGER NOT NULL,
  FOREIGN KEY (question_category_id) REFERENCES question_category(id)
);