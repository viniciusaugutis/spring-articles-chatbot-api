CREATE TABLE IF NOT EXISTS question_category (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

INSERT INTO question_category(name) VALUES ('Arquitetura'), ('Decoração'),
('Sustentabilidade'), ('Paisagismo');