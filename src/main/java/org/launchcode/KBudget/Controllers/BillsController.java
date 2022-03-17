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
    public String displayAllBills(Model model){
        model.addAttribute("title", "Bills");
        model.addAttribute("bill", billsRepository.findAll());

        return "bills/index";
    }
    //lives at /bills/create
    @GetMapping("create")
    public String displayBillForm(Model model){
        model.addAttribute("title", "Add bill");
        model.addAttribute(new Bill());
        return "bills/create";
    }

    //lives at /bills/create
    @PostMapping("create")
    public String processAddBillForm(@ModelAttribute @Valid Bill newBill, Errors errors, Model model) {
        if (errors.hasErrors()) {
           model.addAttribute("errorMsg","Incorrect input");
            return "bills/create";
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

        return "redirect:";
    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", billsRepository.findAll());
        return "bills/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] billId) {

        if (billId != null) {
            for (int id : billId) {
                billsRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
