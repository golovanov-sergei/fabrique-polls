package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.Choice;
import studio.fabrique.polls.service.ChoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/choice")
public class ChoiceController {
    private final ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @ApiOperation(value = "Get list of all choices")
    @GetMapping("/")
    public List<Choice> getAllChoices() {
        return choiceService.getAllChoices();
    }

    @ApiOperation(value = "Get all choices for questionId")
    @GetMapping("/{questionId}")
    public List<Choice> getChoices(@PathVariable Long questionId) {
        return choiceService.getAllChoices(questionId);
    }

    @ApiOperation(value = "Adds list of choices for questionId")
    @PostMapping("/add/{questionId}")
    public List<Choice> updateChoiceList(@RequestBody List<Choice> choiceList, @PathVariable Long questionId) {
        return choiceService.createChoice(choiceList, questionId);
    }

    @ApiOperation(value = "Adds text choices for questionId")
    @PostMapping("/add-text/{questionId}")
    public Choice updateChoice(@RequestBody Choice choice, @PathVariable Long questionId) {
        return choiceService.createTextChoice(choice, questionId);
    }
}
