package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Choice;

import java.util.List;

public interface ChoiceService {
    List<Choice> getAllChoices();
    List<Choice> getAllChoices(Long questionId);
    List<Choice> createChoice(List<Choice> choiceList, Long questionId);
}
