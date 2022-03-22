package studio.fabrique.polls.domain;

import studio.fabrique.polls.enums.QuestionType;

import java.io.Serializable;
import java.util.Objects;

public class QuestionDto implements Serializable {
    private final Long id;
    private final QuestionType questionType;
    private final String name;

    public QuestionDto(Long id, QuestionType questionType, String name) {
        this.id = id;
        this.questionType = questionType;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDto entity = (QuestionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.questionType, entity.questionType) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionType, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "questionType = " + questionType + ", " +
                "name = " + name + ")";
    }
}
