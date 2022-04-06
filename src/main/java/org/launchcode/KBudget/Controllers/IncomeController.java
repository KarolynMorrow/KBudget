package org.launchcode.KBudget.Controllers;


import org.launchcode.KBudget.Models.Bill;
import org.launchcode.KBudget.Models.Income;
import org.launchcode.KBudget.Models.data.BillsRepository;
import org.launchcode.KBudget.Models.data.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @GetMapping("")
    public String displayAllIncome(Model model) {
        model.addAttribute("income", incomeRepository.findAll());
        model.addAttribute("title", "My Income");
        return "incomes/index";
    }

    //lives at /incomes/add
    @GetMapping("add")
    public String displayIncomeForm(Model model) {
        model.addAttribute("title", "Add Income");
        model.addAttribute(new Income());
        return "incomes/add";
    }

    //lives at /incomes/add
    @PostMapping("add")
    public String processAddIncomeForm(@ModelAttribute @Valid Income newIncome, Errors errors) {
        if (errors.hasErrors()) {
            return "incomes/add";
        }
        incomeRepository.save(newIncome);
        return "redirect:";
    }

    @GetMapping("edit/{incomeId}")
    public String displayEditIncomeForm(@PathVariable int incomeId, Model model) {
        Optional<Income> incomeToEdit = incomeRepository.findById(incomeId);
        if (incomeToEdit.isPresent()) {
            Income income = (Income) incomeToEdit.get();
            model.addAttribute("income", income);
            return "incomes/edit";
        } else {

            return "redirect:../";
        }
    }
    @PostMapping("edit")
    public String processEditIncomeForm(@RequestParam int incomeId, Income income, @RequestParam String name, @RequestParam Float payAmount) {

        Optional<Income> incomeToEdit = incomeRepository.findById(incomeId);
        if( incomeToEdit.isPresent()) {
            income.setName(name);

            }

        if( incomeToEdit.isPresent()) {
            income.setPayAmount(payAmount);

            incomeRepository.save(income);
            return "redirect:./";
        }
        return "incomes/edit";

    }


//    (Objects.nonNull(department.getDepartmentName())
//            && !"".equalsIgnoreCase(
//            department.getDepartmentName())) {
//        depDB.setDepartmentName(
//                department.getDepartmentName());


@GetMapping("delete")
public String displayDeleteEventForm(Model model) {
    model.addAttribute("title", "Delete Income");
    model.addAttribute("income", incomeRepository.findAll());
    return "incomes/delete";
}

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] incomeId) {

        if (incomeId != null) {
            for (int id : incomeId) {
                incomeRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
