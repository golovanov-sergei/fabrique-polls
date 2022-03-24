package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.exception.NoSuchEntityException;
import studio.fabrique.polls.repositories.PollRepository;
import studio.fabrique.polls.repositories.QuestionRepository;
import studio.fabrique.polls.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private static final String QUESTION_NOT_FOUND = "Question with Id=%s not found.";
    private static final String POLL_NOT_FOUND = "Poll with Id=%s not found.";

    private final QuestionRepository questionRepository;
    private final PollRepository pollRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, PollRepository pollRepository) {
        this.questionRepository = questionRepository;
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionsFromPoll(Long pollId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NoSuchEntityException(String.format(POLL_NOT_FOUND, pollId)));
        return questionRepository.findAllByPoll(poll);
    }

    @Override
    public Question createQuestion(Question question, Long pollId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NoSuchEntityException(String.format(POLL_NOT_FOUND, pollId)));
        question.setPoll(poll);
        return questionRepository.save(question);
    }

    @Override
    public Question editQuestion(Question question) {
        Question editQuestion = questionRepository.findById(question.getId()).orElseThrow(() -> new NoSuchEntityException(String.format(QUESTION_NOT_FOUND, question.getId())));
        editQuestion.setQuestionType(question.getQuestionType());
        editQuestion.setName(question.getName());
        return questionRepository.save(editQuestion);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

}
