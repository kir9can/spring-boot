package by.tms.springboot.controller;

import by.tms.springboot.entity.Operation;
import by.tms.springboot.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller

@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/go")
    public String operation() {
        return "go";
    }

    @PostMapping("/go")
    public String operation(Operation operation, Model model){
        Optional<Operation> resultOperation = calculatorService.calculate(operation);
        if(resultOperation.isPresent()) {
            model.addAttribute("result", resultOperation.get());
        } else {
            model.addAttribute("result", "error");
        }

        return "go";
    }

    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute("operationHistory", calculatorService.getHistory());

        return "history";
    }

}
