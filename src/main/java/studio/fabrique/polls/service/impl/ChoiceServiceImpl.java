package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Choice;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.repositories.ChoiceRepository;
import studio.fabrique.polls.repositories.QuestionRepository;
import studio.fabrique.polls.service.ChoiceService;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {
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
        Question question = questionRepository.findById(questionId).get();
        return choiceRepository.findByQuestion(question);
    }

    @Override
    public Choice createChoice(Choice choice, Long questionId) {
        Question question = questionRepository.findById(questionId).get();
        choice.setQuestion(question);
        return choiceRepository.save(choice);
    }
}