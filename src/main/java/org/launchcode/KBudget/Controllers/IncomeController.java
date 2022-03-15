package org.launchcode.KBudget.Controllers;


import org.launchcode.KBudget.Models.Income;
import org.launchcode.KBudget.Models.data.BillsRepository;
import org.launchcode.KBudget.Models.data.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("income", incomeRepository.findAll());
        model.addAttribute("title", "My Incomes");
        return "incomes/index";
    }
    //lives at /incomes/add
    @GetMapping("add")
    public String displayIncomeForm(Model model){
        model.addAttribute("title", "Add Income");
        model.addAttribute(new Income());
        return "incomes/add";
    }

    //lives at /incomes/add
    @PostMapping("add")
    public String processAddIncomeForm(@ModelAttribute @Valid Income newIncome, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("errorMsg","Incorrect input");
            return "incomes/add";
        }
        incomeRepository.save(newIncome);
        return "redirect:";
    }
}
