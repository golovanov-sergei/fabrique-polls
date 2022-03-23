package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Choice;

import java.util.List;

public interface ChoiceService {
    List<Choice> getAllCoices();
    Choice saveChoice(Choice choice);
}
