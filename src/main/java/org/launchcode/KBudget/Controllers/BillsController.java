package org.launchcode.KBudget.Controllers;


import org.launchcode.KBudget.Models.Bill;
import org.launchcode.KBudget.Models.data.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Optional;

@Controller
@RequestMapping("bills")
public class BillsController {

    @Autowired
    private BillsRepository billsRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title", "Bills");
        model.addAttribute("bill", billsRepository.findAll());
        return "bills/index";
    }
    //lives at /bills/add
    @GetMapping("add")
    public String displayBillForm(Model model){
        model.addAttribute("title", "Add bill");
        model.addAttribute(new Bill());
        return "bills/add";
    }

    //lives at /bills/add
    @PostMapping("add")
    public String processAddBillForm(@ModelAttribute @Valid Bill newBill, Errors errors, Model model) {
        if (errors.hasErrors()) {
           model.addAttribute("errorMsg","Incorrect input");
            return "bills/add";
        }
        billsRepository.save(newBill);
        return "redirect:";
    }
    @GetMapping("edit/{billId}")
    public String displayEditBillsForm(Model model, @PathVariable int billId){
        Optional<Bill> billToEdit = billsRepository.findById(billId);
        model.addAttribute("bill", billToEdit);
        if( billToEdit.isPresent()){
            Bill bill = (Bill) billToEdit.get();
        }
        //model.addAttribute("title", "Edit Bill " + billsRepository. + " (id=" + billsRepository.getId() + ")";
        return "bills/edit";
    }

    @PostMapping("edit")
    public String processEditBillsForm(int billId, String billName, Date date, Float billAmount) {

        Optional<Bill> billToEdit = billsRepository.findById(billId);
        if( billToEdit.isPresent()){

        }
//        if (billIds != null) {
//            for (int id : billIds) {
//                billsRepository.deleteById(id);
//            }
//        }

        return "redirect:";
    }
}
