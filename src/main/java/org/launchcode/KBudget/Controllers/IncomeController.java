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
import java.sql.Date;
import java.util.Optional;

@Controller
@RequestMapping("incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("income", incomeRepository.findAll());
        model.addAttribute("title", "My Incomes");
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

//    @GetMapping("edit/{incomeId}")
//    public String displayEditIncomeForm(Model model, @PathVariable int incomeId) {
//        Optional<Income> incomeToEdit = incomeRepository.findById(incomeId);
//        model.addAttribute("title", "Edit Income");
//        model.addAttribute("income", incomeToEdit);
//        if (incomeToEdit.isPresent()) {
//            Income income = incomeToEdit.get();
//        }
//        return "incomes/edit";
//    }

//    @PostMapping("edit")
//    public String processEditIncomeForm(int billId, String name, Date payDate, Float payAmount) {
//
//        Optional<Income> incomeToEdit = incomeRepository.findById(billId);
//        if( incomeToEdit.isPresent()){
//            //process the change or delete the income
//            Income income = incomeToEdit.get();
//
//
//        }
//        if (billIds != null) {
//            for (int id : billIds) {
//                billsRepository.deleteById(id);
//            }
//        }
//
//        return "redirect:";
//    }
}
