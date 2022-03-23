package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.repositories.PollRepository;
import studio.fabrique.polls.repositories.QuestionRepository;
import studio.fabrique.polls.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
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
    public Question createQuestion(Question question, Long pollId) {
        Poll poll = pollRepository.findById(pollId).get();
        poll.getQuestions().add(question);
        return questionRepository.save(question);
    }
}
