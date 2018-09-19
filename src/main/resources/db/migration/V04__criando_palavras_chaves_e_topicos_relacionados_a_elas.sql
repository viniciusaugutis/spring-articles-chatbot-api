CREATE TABLE IF NOT EXISTS keyword (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS topic_keyword (
    topic_id INTEGER NOT NULL,
    keyword_id INTEGER NOT NULL,
    PRIMARY KEY (topic_id, keyword_id),
    FOREIGN KEY (topic_id) REFERENCES topic(id),
    FOREIGN KEY (keyword_id) REFERENCES keyword(id)
);