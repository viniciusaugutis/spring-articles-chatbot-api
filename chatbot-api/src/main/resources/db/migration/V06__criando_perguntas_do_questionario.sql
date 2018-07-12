CREATE TABLE IF NOT EXISTS questionary_question(
  questionary_id UUID NOT NULL,
  question_id INTEGER NOT NULL,
  status TEXT NOT NULL,
  meta JSON,
  FOREIGN KEY (questionary_id) REFERENCES questionary(id),
  FOREIGN KEY (question_id) REFERENCES question(id),
  PRIMARY KEY(questionary_id, question_id)
);
