package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ApiOperation(value = "Get all  questions")
    @GetMapping("/")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @ApiOperation(value = "Get all questions from pollId")
    @GetMapping("/{pollId}")
    public List<Question> getAllQuestionsFromPoll(@PathVariable Long pollId) {
        return questionService.getAllQuestionsFromPoll(pollId);
    }

    @ApiOperation(value = "Add new question to pollId")
    @PostMapping("/add/{pollId}")
    public Question createQuestion(@RequestBody Question question, @PathVariable Long pollId) {
        return questionService.createQuestion(question, pollId);
    }

    @ApiOperation(value = "Edit question")
    @PutMapping("/")
    public Question editQuestion(@RequestBody Question question) {
        return questionService.editQuestion(question);
    }

    @ApiOperation(value = "Delete questions by questionId")
    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
    }
}
