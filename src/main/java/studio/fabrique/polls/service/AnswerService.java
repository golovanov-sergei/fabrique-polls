package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswers();
    Answer saveAnswer(Answer answer);
}
