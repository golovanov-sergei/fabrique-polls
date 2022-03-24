package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Choice;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.exception.NoSuchEntityException;
import studio.fabrique.polls.repositories.ChoiceRepository;
import studio.fabrique.polls.repositories.QuestionRepository;
import studio.fabrique.polls.service.ChoiceService;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {
    private static final String QUESTION_NOT_FOUND = "Question with Id=%s not found.";

    private final ChoiceRepository choiceRepository;
    private final QuestionRepository questionRepository;

    public ChoiceServiceImpl(ChoiceRepository choiceRepository, QuestionRepository questionRepository) {
        this.choiceRepository = choiceRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Choice> getAllChoices() {
        return choiceRepository.findAll();
    }

    @Override
    public List<Choice> getAllChoices(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new NoSuchEntityException(String.format(QUESTION_NOT_FOUND, questionId)));
        return choiceRepository.findByQuestion(question);
    }

    @Override
    public List<Choice> createChoice(List<Choice> choiceList, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new NoSuchEntityException(String.format(QUESTION_NOT_FOUND, questionId)));
        choiceList.forEach(c -> {
            c.setQuestion(question);
            choiceRepository.save(c);
        });
        return choiceRepository.saveAll(choiceList);
    }

    @Override
    public Choice createTextChoice(Choice choice, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow();
        choice.setQuestion(question);
        return choiceRepository.save(choice);
    }
}
