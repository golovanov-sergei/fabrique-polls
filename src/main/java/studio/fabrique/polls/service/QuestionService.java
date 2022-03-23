package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question createQuestion(Question question, Long polId);
}
