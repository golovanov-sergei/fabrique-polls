package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getAllQuestionsFromPoll(Long pollId);
    Question createQuestion(Question question, Long polId);
    Question editQuestion(Question question);
    void deleteQuestion(Long questionId);
}
