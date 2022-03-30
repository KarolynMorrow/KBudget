package org.launchcode.KBudget.Controllers;


import org.launchcode.KBudget.Models.Bill;
import org.launchcode.KBudget.Models.data.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("bills")
public class BillsController {

    @Autowired
    private BillsRepository billsRepository;

    @GetMapping("")
    public String displayAllBills(@RequestParam(required = false) Integer billId, Model model) {
//        if (billId == null) {

            model.addAttribute("title", "My Bills");
            model.addAttribute("bill", billsRepository.findAll());
//        } else {
//            Optional<Bill> billToEdit = billsRepository.findById(billId);
//            if (billToEdit.isPresent()) {
//                Bill bill = billToEdit.get();
//                model.addAttribute("bill", bill.getId());
//                model.addAttribute("title", "View bill: " + bill.getBillName());
//            } else {
//                model.addAttribute("title", "Invalid Bill ID");
//            }
//        }
        return "bills/index";
    }

    //lives at /bills/create
    @GetMapping("create")
    public String displayBillForm(Model model){
        model.addAttribute("title", "Add bill");
        model.addAttribute( new Bill());
        return "bills/create";
    }

    //lives at /bills/create
    @PostMapping("create")
    public String processAddBillForm(@ModelAttribute @Valid Bill newBill, Errors errors) {
        if (errors.hasErrors()) {

            return "bills/create";
        }
        billsRepository.save(newBill);
        return "redirect:";
    }

    @GetMapping("edit/{billId}")
    public String displayEditBillsForm(@PathVariable int billId, Model model) {
        Optional<Bill> billToEdit = billsRepository.findById(billId);
        if (billToEdit.isPresent()) {
            Bill bill = (Bill) billToEdit.get();
            model.addAttribute("bill", bill);
//            model.addAttribute("title", "Edit bill: " + bill.getBillName());
            return "bills/edit";
        } else {
            //model.addAttribute("title", "Edit Bill " + billsRepository. + " (id=" + billsRepository.getId() + ")";
            return "redirect:../";
        }
    }

//    @PostMapping("edit")
//    public String processEditBillsForm(@RequestParam @Valid int billId, @RequestParam @Valid String billName, @RequestParam @Valid Date date, @RequestParam @Valid Float billAmount) {
//
//        Optional<Bill> billToEdit = billsRepository.findById(billId);
//        if( billToEdit.isPresent()){
//
//
//
//            return "bills/edit";
//
//
//        }
//
//        return "bills/edit";
//    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Bills");
        model.addAttribute("bills", billsRepository.findAll());
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
