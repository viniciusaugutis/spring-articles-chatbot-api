CREATE TABLE IF NOT EXISTS keyword (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS question_keyword (
    question_id INTEGER NOT NULL,
    keyword_id INTEGER NOT NULL,
    PRIMARY KEY (question_id, keyword_id),
    FOREIGN KEY (question_id) REFERENCES question(id),
    FOREIGN KEY (keyword_id) REFERENCES keyword(id)
);